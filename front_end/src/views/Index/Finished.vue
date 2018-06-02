<template>
  <v-app
    id="inspire"
  >
    <v-container fluid>
      <v-layout class="gap">
        <v-flex>
          <h2>已完成</h2>
        </v-flex>
      </v-layout>
      <v-layout class="gap">
        <v-flex>
          <v-divider></v-divider>
          <v-card
            v-for="todoItem in todoItems"
            :key="todoItem.todoNum"
          >
            <v-toolbar>
              <v-icon v-if="todoItem.priorityLevel == 'p3'">looks_3</v-icon>
              <v-icon v-else-if="todoItem.priorityLevel == 'p2'">looks_two</v-icon>
              <v-icon v-else-if="todoItem.priorityLevel == 'p1'">looks_one</v-icon>
              <v-icon v-else>indeterminate_check_box</v-icon>

              <v-flex class="CheckBox">
                <v-checkbox
                  input-value="true" value
                  @click="recoverTodo(todoItem.todoNum)"
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
          <v-flex>
          </v-flex>
        </v-flex>
      </v-layout>
    </v-container>
  </v-app>
</template>

<script>
export default {
  data: () => ({
    todoItems: []
  }),

  mounted () {
    this.$nextTick(function () {
      this.findFinishedTodo()
    })
  },

  methods: {
    findFinishedTodo () {
      var that = this

      this.axios({
        headers: { 'token': localStorage.token },
        method: 'GET',
        url: '/todo/findfinishedtodo',
        data: {},
        dataType: 'json'
      })
      .then(function (response) {
        that.todoItems = response.data

        that.$store.commit('saveFinishedTodo', response.data)
      })
      .catch(function (error) {
        console.log(error)
      })
    },
    recoverTodo (toduNum) {
      var that = this

      var thisTodoNum = toduNum

      this.axios({
        headers: { 'token': localStorage.token },
        method: 'PATCH',
        url: '/todo/recover' + '/' + thisTodoNum,
        data: {},
        dataType: 'json'
      })
      .then(function (response) {
        that.findFinishedTodo()
      })
      .catch(function (error) {
        console.log(error)
      })
    }
  }
}
</script>

<style scoped>
hr {
  margin-top: 10px;
}
.gap {
  margin-bottom: 30px;
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
