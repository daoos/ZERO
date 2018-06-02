<template>
  <v-container fluid>
    <v-layout class="gap">
      <v-flex>
        <h2>优先级1</h2>
      </v-flex>
    </v-layout>
    <v-layout
        class="gap"
        v-show="Expired"
        v-if="!this.expiredTodoItems.length == 0"
      >
        <v-flex>
          <h4 class="Expired">已过期</h4>
          <v-divider></v-divider>
          <template v-for="expiredTodoItem in expiredTodoItems">
            <v-card
              v-if="expiredTodoItem.isShow"
              :key="expiredTodoItem.todoNum"
            >
              <v-toolbar>
                <v-icon v-if="expiredTodoItem.priorityLevel == 'p3'">looks_3</v-icon>
                <v-icon v-else-if="expiredTodoItem.priorityLevel == 'p2'">looks_two</v-icon>
                <v-icon v-else-if="expiredTodoItem.priorityLevel == 'p1'">looks_one</v-icon>
                <v-icon v-else>indeterminate_check_box</v-icon>

                <v-flex class="CheckBox">
                  <v-checkbox
                    value
                    @click="finishExpiredTodo(expiredTodoItem)"
                  ></v-checkbox>
                </v-flex>

                <span>{{ expiredTodoItem.todoContent }}</span>

                <v-spacer></v-spacer>

                <v-flex
                  class="Inventory"
                  v-if="expiredTodoItem.invTitle != '无'"
                >
                  <v-icon>bookmark</v-icon>
                  <span>{{ expiredTodoItem.invTitle }}</span>
                </v-flex>
              </v-toolbar>
            </v-card>
          </template>
        </v-flex>
      </v-layout>
      <v-layout class="gap">
        <v-flex>
          <v-flex
            v-if="!this.todoItems.length == 0"
          >
            <span><b>进行中</b></span>
          </v-flex>
          <v-divider></v-divider>
          <template v-for="todoItem in todoItems">
            <v-card v-if="todoItem.isShow" :key="todoItem.todoNum">
              <v-toolbar>
                <v-icon v-if="todoItem.priorityLevel == 'p3'">looks_3</v-icon>
                <v-icon v-else-if="todoItem.priorityLevel == 'p2'">looks_two</v-icon>
                <v-icon v-else-if="todoItem.priorityLevel == 'p1'">looks_one</v-icon>
                <v-icon v-else>indeterminate_check_box</v-icon>

                <v-flex class="CheckBox">
                  <v-checkbox
                    value
                    @click="finishTodo(todoItem)"
                  ></v-checkbox>
                </v-flex>

                <span>{{ todoItem.todoContent }}</span>

                <v-spacer></v-spacer>

                <v-flex
                  class="Inventory"
                  v-if="todoItem.invTitle != '无'"
                >
                  <v-icon>bookmark</v-icon>
                  <span>{{ todoItem.invTitle }}</span>
                </v-flex>
              </v-toolbar>
            </v-card>
          </template>
        </v-flex>
      </v-layout>
    <v-snackbar
      :timeout="timeout"
      :bottom="'bottom'"
      v-model="snackbarExpired"
    >
      完成一条待办事项
      <v-btn
        flat color="pink"
        @click="revokeExpiredFinished"
      >
        撤销
      </v-btn>
    </v-snackbar>
    <v-snackbar
      :timeout="timeout"
      :bottom="'bottom'"
      v-model="snackbar"
    >
      完成一条待办事项
      <v-btn
        flat color="pink"
        @click="revokeFinished"
      >
        撤销
      </v-btn>
    </v-snackbar>
  </v-container>
</template>

<script>

export default {
  data: () => ({
    Expired: true,
    expiredTodoNum: null,
    todoNum: null,
    TodoNum: '',
    expiredTodoItems: [],
    todoItems: [],
    snackbarExpired: false,
    snackbar: false,
    timeout: 3000,
    setTime: null,
    inventory: [],
    priority: [
      { text: '优先级1' },
      { text: '优先级2' },
      { text: '优先级3' }
    ]
  }),

  mounted () {
    this.$nextTick(function () {
      this.findInventory(),
      this.findExpiredTodo(),
      this.findTodo()
    })
  },

  methods: {
    findInventory () {
      var that = this

      this.axios({
        headers: { 'token': localStorage.token },
        method: 'GET',
        url: '/inventory/find',
        data: {},
        dataType: 'json'
      })
      .then(function (response) {
        let arr = response.data
        arr.forEach( (item, index) => {
          that.inventory.push({text:item.invTitle})
        })
      })
      .catch(function (error) {
        console.log(error)
      })
    },
    findExpiredTodo () {
      var that = this

      this.axios({
        headers: { 'token': localStorage.token },
        method: 'GET',
        url: '/todo/findexpiredtodobypri/' + 'p1',
        data: {},
        dataType: 'json'
      })
      .then(function (response) {
        that.expiredTodoItems=[]
        response.data.forEach( (item, index) => {
          that.expiredTodoItems.push({
            isShow: true, ...item
          })
        })

        that.$store.commit('saveExpiredTodo', response.data)
      })
      .catch(function (error) {
        console.log(error)
      })
    },
    findTodo () {
      var that = this

      this.axios({
        headers: { 'token': localStorage.token },
        method: 'GET',
        url: '/todo/findtodobypri/' + 'p1',
        data: {},
        dataType: 'json'
      })
      .then(function (response) {
        that.todoItems=[]
        response.data.forEach( (item, index) => {
          that.todoItems.push({
            isShow: true, ...item
          })
        })

        that.$store.commit('saveTodo', response.data)
      })
      .catch(function (error) {
        console.log(error)
      })
    },
    finishExpiredTodo (todoNum) {
      this.expiredTodoNum = todoNum

      todoNum.isShow = false
      this.snackbarExpired = true

      this.setTime = setTimeout(() => {
        var that = this

        this.axios({
          headers: { 'token': localStorage.token },
          method: 'PATCH',
          url: '/todo/finish' + '/' + this.expiredTodoNum.todoNum,
          data: {},
          dataType: 'json'
        })
        .then(function (response) {
          that.findExpiredTodo()
        })
        .catch(function (error) {
          console.log(error)
        })
      }, 3000);
    },
    revokeExpiredFinished () {
      this.snackbarExpired = false
      this.expiredTodoNum.isShow = true

      clearTimeout(this.setTime)
    },
    finishTodo (todoNum) {
      this.todoNum = todoNum

      todoNum.isShow = false
      this.snackbar = true

      this.setTime = setTimeout(() => {
        var that = this

        this.axios({
          headers: { 'token': localStorage.token },
          method: 'PATCH',
          url: '/todo/finish' + '/' +  this.todoNum.todoNum,
          data: {},
          dataType: 'json'
        })
        .then(function (response) {
          that.findTodo()
        })
        .catch(function (error) {
          console.log(error)
        })
      }, 3000);
    },
    revokeFinished () {
      this.todoNum.isShow = true
      this.snackbar = false

      clearTimeout(this.setTime)
    }
  }
}
</script>

<style scoped>
hr {
  margin-top: 6px;
}
.gap {
  margin-bottom: 30px;
}
.Expired {
  color: #C62828;
}
.date {
  margin-left: 5px;
  font-size: 14px;
  color: #757575;
}
.CheckBox {
  margin-top: 25px;
  margin-left: 20px;
  max-width: 50px;;
}
.Inventory {
  position: absolute;
  right: 100px;
}
</style>
