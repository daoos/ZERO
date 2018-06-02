<template>
  <v-app id="inspire">
    <v-container fluid>
      <v-layout class="gap">
        <v-flex>
          <h2>今天</h2>
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

                <v-icon
                  class="settingButton"
                  @click="modifyTodo(expiredTodoItem.todoNum, expiredTodoItem.todoContent, expiredTodoItem.todoReminderTime,
                                     expiredTodoItem.invTitle, expiredTodoItem.priorityLevel)"
                >
                  more_horiz
                </v-icon>

                <v-icon
                  class="deleteButton"
                  @click="deleteExpiredTodo(expiredTodoItem.todoNum)"
                >
                  delete_forever
                </v-icon>
              </v-toolbar>
            </v-card>
          </template>
        </v-flex>
      </v-layout>
      <v-layout class="gap">
        <v-flex>
          <v-flex>
            <span><b>今天</b></span>
            <span class="date">{{ Week }}</span>
            <span class="date">{{ Day }}</span>
          </v-flex>
          <v-divider></v-divider>
          <template v-for="todoItem in todoItems">
            <v-card
              v-if="todoItem.isShow"
              :key="todoItem.todoNum"
            >
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

              <v-icon
                class="settingButton"
                @click="modifyTodo(todoItem.todoNum, todoItem.todoContent, todoItem.todoReminderTime,
                                   todoItem.invTitle, todoItem.priorityLevel)"
              >
                more_horiz
              </v-icon>

              <v-icon
                class="deleteButton"
                @click="deleteTodo(todoItem.todoNum)"
              >
                delete_forever
              </v-icon>
            </v-toolbar>
          </v-card>
          </template>
          <v-flex>
            <v-btn
              block flat
              @click="showAddTodoDialog"
            >
              <v-icon>add</v-icon>
            </v-btn>
          </v-flex>
        </v-flex>
        <v-dialog
          persistent max-width="700px"
          v-model="addTodoDialog"
        >
          <v-form>
            <v-card>
              <v-card-title>
                <span class="headline">添加待办事项</span>
              </v-card-title>
              <v-card-text>
                <v-container grid-list-md>
                  <v-layout wrap>
                    <v-flex sm12 md12>
                      <v-text-field
                        solo class="elevation-5"
                        v-model="todoContent"
                      ></v-text-field>
                    </v-flex>
                    <v-flex sm6 md6>
                      <v-menu
                        lazy full-width offset-y ref="menu_date" transition="scale-transition" min-width="290px"
                        v-model="menu_date"
                        :close-on-content-click="false"
                        :nudge-right="20"
                        :return-value.sync="date"
                      >
                        <v-text-field
                          readonly solo prepend-icon="event" slot="activator" class="elevation-5"
                          v-model="date"
                        ></v-text-field>
                        <v-date-picker
                          locale="zh-cn"
                          :min="Today"
                          v-model="date"
                          @input="$refs.menu_date.save(date)"
                        ></v-date-picker>
                      </v-menu>
                    </v-flex>
                    <v-flex sm6 md6>
                      <v-menu
                        lazy full-width offset-y ref="menu_time" transition="scale-transition" min-width="290px"
                        v-model="menu_time"
                        :close-on-content-click="false"
                        :nudge-left="80"
                        :return-value.sync="time"
                      >
                        <v-text-field
                          readonly solo prepend-icon="access_time" slot="activator" class="elevation-5"
                          v-model="time"
                        ></v-text-field>
                        <v-time-picker
                          v-model="time"
                          :landscape="landscape"
                          @input="$refs.menu_time.save(time)"
                        ></v-time-picker>
                      </v-menu>
                    </v-flex>
                    <v-flex sm6 md6>
                      <v-select
                        hide-details solo prepend-icon="bookmark" label="清单" min-width="320px"
                        v-model="Inventory"
                        :items="inventory"
                      ></v-select>
                    </v-flex>
                    <v-flex sm6 md6>
                      <v-select
                        hide-details solo prepend-icon="looks" label="优先级" min-width="320px"
                        v-model="Priority"
                        :items="priority"
                      ></v-select>
                    </v-flex>
                  </v-layout>
                </v-container>
              </v-card-text>
              <v-card-actions>
                <v-btn
                  dark color="grey darken-4"
                  @click="saveNewTodo"
                >
                  保存
                </v-btn>
                <v-btn @click="hideAddTodoDialog">取消</v-btn>
              </v-card-actions>
            </v-card>
          </v-form>
        </v-dialog>
        <v-dialog
          persistent max-width="700px"
          v-model="modifyTodoDialog"
        >
          <v-form>
            <v-card>
              <v-card-title>
                <span class="headline">修改待办事项</span>
              </v-card-title>
              <v-card-text>
                <v-container grid-list-md>
                  <v-layout wrap>
                    <v-flex sm12 md12>
                      <v-text-field
                        solo class="elevation-5"
                        v-model="modify_TodoContent"
                      ></v-text-field>
                    </v-flex>
                    <v-flex sm6 md6>
                      <v-menu
                        lazy full-width offset-y ref="modify_menu_date" transition="scale-transition" min-width="290px"
                        v-model="modify_menu_date"
                        :close-on-content-click="false"
                        :nudge-right="20"
                        :return-value.sync="modify_date"
                      >
                        <v-text-field
                          readonly solo prepend-icon="event" slot="activator" class="elevation-5"
                          v-model="modify_date"
                        ></v-text-field>
                        <v-date-picker
                          locale="zh-cn"
                          :min="Today"
                          v-model="modify_date"
                          @input="$refs.modify_menu_date.save(modify_date)"
                        ></v-date-picker>
                      </v-menu>
                    </v-flex>
                    <v-flex sm6 md6>
                      <v-menu
                        lazy full-width offset-y ref="modify_menu_time" transition="scale-transition" min-width="290px"
                        v-model="modify_menu_time"
                        :close-on-content-click="false"
                        :nudge-left="80"
                        :return-value.sync="modify_time"
                      >
                        <v-text-field
                          readonly solo prepend-icon="access_time" slot="activator" class="elevation-5"
                          v-model="modify_time"
                        ></v-text-field>
                        <v-time-picker
                          v-model="modify_time"
                          :landscape="landscape"
                          @input="$refs.modify_menu_time.save(modify_time)"
                        ></v-time-picker>
                      </v-menu>
                    </v-flex>
                    <v-flex sm6 md6>
                      <v-select
                        hide-details solo prepend-icon="bookmark" :label="InvTitle" min-width="320px"
                        v-model="modify_Inventory"
                        :items="inventory"
                      ></v-select>
                    </v-flex>
                    <v-flex sm6 md6>
                      <v-select
                        hide-details solo prepend-icon="looks" :label="PriorityLevel" min-width="320px"
                        v-model="modify_Priority"
                        :items="priority"
                      ></v-select>
                    </v-flex>
                  </v-layout>
                </v-container>
              </v-card-text>
              <v-card-actions>
                <v-btn
                  dark color="grey darken-4"
                  @click="saveModifyTodo"
                >
                  保存
                </v-btn>
                <v-btn @click="hideModifyTodoDialog">取消</v-btn>
              </v-card-actions>
            </v-card>
          </v-form>
        </v-dialog>
        <v-dialog
          max-width="300px"
          v-model="deleteExpiredTodoDialog"
        >
          <v-card>
              <v-alert :value="true" type="error">
                是否确认删除该待办事项条目?
              </v-alert>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn
                @click="confirmDelExpiredTodo"
              >
                确定
              </v-btn>
              <v-btn
                @click="cancleDelExpiredTodo"
              >
                取消
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
        <v-dialog
          max-width="300px"
          v-model="deleteTodoDialog"
        >
          <v-card>
              <v-alert :value="true" type="error">
                是否确认删除该待办事项条目?
              </v-alert>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn
                @click="confirmDelTodo"
              >
                确定
              </v-btn>
              <v-btn
                @click="cancleDelTodo"
              >
                取消
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
        <v-snackbar
          v-model="snackbar_ExpiredTodo"
          :timeout="timeout"
          :bottom="'bottom'"
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
          v-model="snackbar_Todo"
          :timeout="timeout"
          :bottom="'bottom'"
        >
          完成一条待办事项
          <v-btn
            flat color="pink"
            @click="revokeFinished"
          >
            撤销
          </v-btn>
        </v-snackbar>
        <v-dialog
          max-width="350px"
          v-model="Alram"
        >
          <v-alert
            type="warning"
            :value="true"
          ></v-alert>
          <v-card>
            <v-card-text>
              您有一条待办事项需要完成!
            </v-card-text>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn @click.stop="Alram = false">知道了</v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
      </v-layout>
    </v-container>
  </v-app>
</template>

<script>
export default {
  data: () => ({
    Expired: true,
    todoNum: null,
    expiredTodoNum: null,
    addTodoDialog: false,
    todoContent: '',
    menu_date: false,
    date: null,
    menu_time: false,
    time: null,
    landscape: true,
    select: false,
    Inventory: null,
    Priority: null,
    modifyTodoDialog: false,
    modify_TodoContent: '',
    modify_menu_date: false,
    modify_date: null,
    modify_menu_time: false,
    modify_time: null,
    modify_Inventory: '个人',
    modify_Priority: null,
    TodoNum: '',
    TodoContent: '',
    TodoReminderDate: '',
    TodoReminderTime: '',
    InvTitle: '',
    PriorityLevel: '',
    deleteExpiredTodoDialog: false,
    deleteTodoDialog: false,
    expiredTodoItems: [],
    todoItems: [],
    deleteExpiredTodoNum: '',
    deleteTodoNum: '',
    snackbar_Todo: false,
    snackbar_ExpiredTodo: false,
    timeout: 3000,
    setTime: null,
    Alram: false,
    userTime: null,
    inventory: [],
    priority: [
      { text: '无优先级' },
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

  computed: {
    Week: function () {
      return new Date().toLocaleString('zh-CN', {weekday: 'long'})
    },
    Day: function () {
      var year = new Date().toLocaleString('en-GB', {year: 'numeric'})
      var month = new Date().toLocaleString('en-GB', {month: 'numeric'})
      var day = new Date().toLocaleString('en-GB', {day: 'numeric'})
      var Day = year + "-" + month + "-" + day
      return Day
    },
    today: function () {
      var date = new Date()
      var newDate = date.getTime()
      date.setTime(newDate)
      var today = date.getFullYear() + "-" + (date.getMonth()+1) + "-" + date.getDate()
      return today
    },
    Today: function () {
      var date = new Date()
      // date.setDate(date.getDate() + 1)
      var Today = date.toISOString().substr(0, 10)
      return Today
    }
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
          that.inventory.push({text: item.invTitle})
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
        url: '/todo/findexpiredtodo',
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

      var thisToday = this.today

      this.axios({
        headers: { 'token': localStorage.token },
        method: 'GET',
        url: '/todo/findtodobydate/' + thisToday,
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
    saveNewTodo () {
      var that = this

      var thisToday = new Date(this.Today)

      var reminderTime = this.date + " " + this.time + ":00"
      this.userTime = reminderTime

      var thisInvTitle = this.Inventory
      if ( thisInvTitle === null ) {
        thisInvTitle = '无'
      }
      else {
        thisInvTitle = thisInvTitle.text
      }

      var thisPriority = this.Priority
      if( thisPriority === null || thisPriority.text === '无优先级' ) {
        thisPriority = 'p0'
      }
      else if ( thisPriority.text === '优先级1' ) {
        thisPriority = 'p1'
      }
      else if ( thisPriority.text === '优先级2' ) {
        thisPriority = 'p2'
      }
      else {
        thisPriority = 'p3'
      }

      this.axios({
        headers: { 'token': localStorage.token },
        method: 'POST',
        url: '/todo/add',
        data: {
          "todoCreateTime": thisToday,
          "todoContent": that.todoContent,
          "todoReminderTime": reminderTime,
          "invTitle": thisInvTitle,
          "priorityLevel": thisPriority
        },
        dataType: 'json'
      })
      .then(function (response) {
        that.todoContent = ''
        that.date = null
        that.time = null
        that.Inventory = null
        that.Priority = null
        that.addTodoDialog = false

        that.findTodo()
        that.setAlram()
      })
      .catch(function (error) {
        console.log(error)
      })
    },
    showAddTodoDialog () {
      this.addTodoDialog = true
    },
    hideAddTodoDialog () {
      this.todoContent = ''
      this.date = null
      this.time = null
      this.Inventory = null
      this.Priority = null
      this.addTodoDialog = false
    },
    setAlram () {
      var timtestamp = Date.parse(new Date())
      var userTime = Date.parse(new Date(this.userTime))
      var alramTime = userTime - timtestamp

      console.log(alramTime)

      setTimeout( () => {
        this.Alram = true
      }, alramTime);
    },
    modifyExpiredTodo (todoNum) {
      this.expiredTodoNum = todoNum
      this.modifyTodoDialog = true
    },
    modifyTodo (todoNum, todoContent, todoReminderTime, invTitle, priorityLevel) {
      this.TodoNum = todoNum
      this.TodoContent = todoContent
      this.modify_TodoContent = this.TodoContent
      this.TodoReminderDate = todoReminderTime.substr(0,10)
      this.modify_date = this.TodoReminderDate
      this.TodoReminderTime = todoReminderTime.substr(11,15)
      this.modify_time = this.TodoReminderTime.substr(0,5)
      this.InvTitle = invTitle
      this.modify_Inventory = this.InvTitle
      let level = + (priorityLevel.split('')[1])
      if ( level === 0 ) {
        this.PriorityLevel = '无优先级'
      }
      else {
        this.PriorityLevel = '优先级' + level
      }
      this.modify_Priority = this.PriorityLevel

      this.modifyTodoDialog = true
    },
    saveModifyTodo (todoNum) {
      var that = this

      var reminderTime = this.modify_date + " " + this.modify_time + ":00"
      // this.userTime = reminderTime

      var thisToday = new Date(this.Today)

      var thisInvTitle = this.modify_Inventory
      if ( thisInvTitle === null ) {
        thisInvTitle = '无'
      }
      else {
        thisInvTitle = thisInvTitle.text
      }

      var thisPriority = this.modify_Priority
      if( this.modify_Priority.text === '无优先级' ) {
        thisPriority = 'p0'
      }
      else if ( this.modify_Priority.text === '优先级1' ) {
        thisPriority = 'p1'
      }
      else if ( this.modify_Priority.text === '优先级2' ) {
        thisPriority = 'p2'
      }
      else {
        thisPriority = 'p3'
      }

      this.axios({
        headers: { 'token': localStorage.token },
        method: 'PATCH',
        url: '/todo/modify/' + this.TodoNum,
        data: {
          "todoCreateTime": thisToday,
          "todoContent": that.modify_TodoContent,
          "todoReminderTime": reminderTime,
          "invTitle": thisInvTitle,
          "priorityLevel": thisPriority
        },
        dataType: 'json'
      })
      .then(function (response) {
        that.modify_TodoContent = ''
        that.modify_date = null
        that.modify_time = null
        that.modify_Inventory = null
        that.modify_Priority = null
        that.modifyTodoDialog = false

        // that.setAlram()
        that.findTodo()
        that.findExpiredTodo()
      })
      .catch(function (error) {
        console.log(error)
      })
    },
    hideModifyTodoDialog () {
      this.modify_TodoContent = ''
      this.modify_date = null
      this.modify_time = null
      this.modify_Inventory = null
      this.modify_Priority = null
      this.modifyTodoDialog = false
    },
    deleteExpiredTodo (todoNum) {
      this.deleteExpiredTodoNum = todoNum
      this.deleteExpiredTodoDialog = true
    },
    cancleDelExpiredTodo (todoNum) {
      this.deleteExpiredTodoDialog = false
    },
    confirmDelExpiredTodo () {
      var that = this

      var Num = this.deleteExpiredTodoNum

      this.axios({
        headers: { 'token': localStorage.token },
        method: 'DELETE',
        url: '/todo/delete' + '/' + Num,
        data: {},
        dataType: 'json'
      })
      .then(function (response) {
        that.deleteExpiredTodoDialog = false
        that.findExpiredTodo()
      })
      .catch(function (error) {
        console.log(error)
      })
    },
    deleteTodo (todoNum) {
      this.deleteTodoNum = todoNum
      this.deleteTodoDialog = true
    },
    cancleDelTodo (todoNum) {
      this.deleteTodoDialog = false
    },
    confirmDelTodo () {
      var that = this

      var todoNum = this.deleteTodoNum

      this.axios({
        headers: { 'token': localStorage.token },
        method: 'DELETE',
        url: '/todo/delete' + '/' + todoNum,
        data: {},
        dataType: 'json'
      })
      .then(function (response) {
        that.deleteTodoDialog = false
        that.findTodo()
      })
      .catch(function (error) {
        console.log(error)
      })
    },
    finishExpiredTodo (todoNum) {
      this.expiredTodoNum = todoNum

      todoNum.isShow = false
      this.snackbar_ExpiredTodo = true

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
      }, 3000)
    },
    revokeExpiredFinished () {
      this.snackbar_ExpiredTodo = false
      this.expiredTodoNum.isShow = true

      clearTimeout(this.setTime)
    },
    finishTodo (todoNum) {
      this.todoNum = todoNum

      todoNum.isShow = false
      this.snackbar_Todo = true

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
      this.snackbar_Todo = false
      this.todoNum.isShow = true

      clearTimeout(this.setTime)
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
.settingButton {
  margin-right: 15px;
  opacity: 0;
}
.settingButton:hover {
  opacity: 1;
}
.deleteButton {
  opacity: 0;
}
.deleteButton:hover {
  opacity: 1;
}
</style>
