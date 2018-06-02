<template>
  <v-app id="inspire">
    <v-navigation-drawer
      app clipped fixed right
      v-model="drawerRight"
    >
      <v-list
        dense
        v-show="Menu"
      >
        <v-list-tile class="gap" @click="$router.push('/index')">
          <v-list-tile-action>
            <v-icon>exit_to_app</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title>返回</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>
      </v-list>
      <v-list
        dense
        v-show="TeamworkMenu"
      >
        <v-list-tile
          class="gap"
          @click="showTeamworkGroupMember"
        >
          <v-list-tile-action>
            <v-icon>group</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title>讨论组成员</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>
        <v-list-tile
          class="gap"
          @click="showSchedulePage"
        >
          <v-list-tile-action>
            <v-icon>date_range</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title>团队日程</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>
        <v-list-tile class="gap"
          @click="showTaskPage">
          <v-list-tile-action>
            <v-icon>donut_large</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title>任务管理</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>
        <v-list-tile class="gap" @click="$router.push('/index')">
          <v-list-tile-action>
            <v-icon>exit_to_app</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title>返回</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>
      </v-list>
    </v-navigation-drawer>
    <v-toolbar
      app dark fixed color="blue-grey"
      clipped-right
    >
      <v-toolbar-side-icon @click.stop="drawer = !drawer"></v-toolbar-side-icon>
      <v-toolbar-title>团队协作</v-toolbar-title>
      <v-spacer></v-spacer>
      <v-toolbar-side-icon @click.stop="drawerRight = !drawerRight"></v-toolbar-side-icon>
    </v-toolbar>
    <v-navigation-drawer
      app fixed
      v-model="drawer"
    >
      <template v-for="group in groups">
        <v-layout
          class="Group"
          :key="group.groupNum"
          @click="showTeamworkPage(group.groupNum, group.groupName)"
        >
          <v-flex xs3 class="GroupAvatar">
            <v-avatar size="45">
              <img :src="group.userAvatarPath" />
            </v-avatar>
          </v-flex>
          <v-flex xs9 class="GroupName">
            <span>{{ group.groupName }}</span>
          </v-flex>
        </v-layout>
      </template>
      <v-btn
        flat block small
        @click="showCreateGroupDialog"
      >
        <v-icon>add</v-icon>
      </v-btn>
    </v-navigation-drawer>
    <v-content v-show="ChatWindow">
      <v-container>
        <v-layout class="space">
          <v-toolbar  dark color="light-blue darken-2">
            <h3
              class="GroupDetails"
              @click="showGroupDetails"
            >
              {{ this.groupName }}
            </h3>
            <v-spacer></v-spacer>
          </v-toolbar>
        </v-layout>
        <v-layout>
          <v-card id="Container" class="TheChatWindow" height="520px">
            <template v-for="message in messages">
              <v-card-text :key="message.messNum">
              <v-avatar size="60">
                <img :src="message.userAvatarPath"/>
              </v-avatar>
              <span class="MessageBox">
                <span v-html="message.message" class="Message"></span>
              </span>
            </v-card-text>
            </template>
          </v-card>
        </v-layout >
        <v-layout wrap>
          <v-flex xs12>
            <v-text-field
              textarea no-resize label="请键入消息内容"
              v-model="TextArea"
            ></v-text-field>
          </v-flex>
        </v-layout>
        <v-layout>
          <v-spacer></v-spacer>
          <v-btn
            class="SendButton"
            @click="sendMessage"
          >
            发送
          </v-btn>
        </v-layout>
      </v-container>
    </v-content>
    <v-dialog
      hide-overlay persistent max-width="500"
      v-model="CreateGroupDialog"
    >
      <v-form>
        <v-card>
          <v-card-title>
            <h3 class="mx-auto">新建讨论组</h3>
          </v-card-title>
          <v-card-text>
            <v-alert
              dismissible transition="scale-transition" class="gap" type="error"
              v-model="error"
            >
              该讨论组名称已被占用，请重新输入
            </v-alert>
            <v-flex>
              <v-text-field
                solo class="gap elevation-6" label="请输入讨论组名称"
                v-model="newGroupName"
                :error-messages="newGroupNameErrors"
                @input="$v.newGroupName.$touch()"
              ></v-text-field>
            </v-flex>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
              <v-btn
                dark class="blue-grey darken-1"
                @click="createGroup"
              >
                创建
              </v-btn>
              <v-btn
                @click="cancleCreateGroup"
              >
                取消
              </v-btn>
          </v-card-actions>
        </v-card>
      </v-form>
    </v-dialog>
    <v-dialog
      max-width="500"
      v-model="GroupDetailsDialog"
    >
      <v-form>
        <v-card>
            <v-toolbar dark class="light-blue darken-3">
              <h3 class="mx-auto">讨论组详情</h3>
            </v-toolbar>
          <v-card-text>
            <template v-for="GroupDetail in GroupDetails">
              <v-card flat :key="GroupDetail.groupName">
                <v-flex class="DetailsGap">
                  <span class="DetailsTitle">讨论组名称:</span>
                  <span class="DetailsContent">{{ GroupDetail.groupName }}</span><br />
                </v-flex>
                <v-flex class="DetailsGap">
                  <span class="DetailsTitle">创建时间:</span>
                  <span class="DetailsContent">{{ GroupDetail.groupCreateTime }}</span><br />
                </v-flex>
                <v-flex class="DetailsGap">
                  <span class="DetailsTitle"><span>创建者:</span></span>
                  <span class="DetailsContent">{{ GroupDetail.creator }}</span>
                </v-flex>
              </v-card>
            </template>
          </v-card-text>
          <v-card-actions>
            <v-btn
              block class="primary"
              v-if="this.userPermission == 'all'"
              @click="deleteGroup"
            >
              删除该讨论组
            </v-btn>
            <v-btn
              block class="primary"
              v-else
              @click="leaveGroup"
            >
              退出该讨论组
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-form>
    </v-dialog>
    <v-layout>
      <v-navigation-drawer
        fixed right temporary
        v-model="TeamworkTaskPage"
      >
        <v-flex class="ButtonGroup">
          <v-btn
            flat outline class="TeamworkPageTopButton"
            @click="listTaskForMe"
          >
            分配给自己的
          </v-btn>
          <v-btn
            flat outline class="TeamworkPageTopButton"
            @click="listTaskForElse"
          >
            分配给他人的
          </v-btn>
        </v-flex>
        <v-divider></v-divider>
        <v-layout
          wrap
        >
          <template v-for="taskForMe in tasksForMe">
            <v-card
              flat class="TaskContentContainer"
              :key="taskForMe.taskNum"
            >
              <v-card-title>
                <span class="">{{ taskForMe.taskCreateTime }}</span>
                <span class="TaskContent">{{ taskForMe.taskContent }}</span>
              </v-card-title>
              <v-card-text>
                <v-icon
                  class="TaskButton"
                  @click="finishTask(taskForMe.taskNum)"
                >
                  done
                </v-icon>
                <v-icon
                  class="TaskButton"
                  @click="deleteTask(taskForMe.taskNum)"
                >
                  close
                </v-icon>
              </v-card-text>
            </v-card>
          </template>
        </v-layout>
        <v-layout
          wrap
        >
          <template v-for="taskForElse in tasksForElse">
            <v-card
              flat class="TaskContentContainer"
              :key="taskForElse.taskNum"
            >
              <v-card-title>
                <v-avatar
                  size="50"
                >
                  <img :src="taskForElse.userAvatarPath" />
                </v-avatar>
                <span class="ElseTaskContent">{{ taskForElse.taskContent }}</span>
              </v-card-title>
            </v-card>
          </template>
        </v-layout>
        <v-divider></v-divider>
        <v-btn
          block
          v-if="this.userPermission == 'all'"
          @click="showAddTaskDialog"
        >
          添加任务
        </v-btn>
        <v-dialog
          max-width="800px"
          v-model="addTaskDialog"
        >
          <v-card>
            <v-card-title>
              <h2>添加任务</h2>
            </v-card-title>
            <v-divider></v-divider>
            <v-card-text>
              <v-layout wrap>
                <v-flex xs3 class="AddTaskField">
                  <v-menu
                    lazy full-width offset-y ref="task_menu_date" transition="scale-transition" min-width="290px"
                    v-model="task_menu_date"
                    :close-on-content-click="false"
                    :nudge-left="60"
                    :return-value.sync="task_date"
                  >
                    <v-text-field
                      readonly solo prepend-icon="event" slot="activator" class="elevation-5"
                      v-model="task_date"
                    ></v-text-field>
                    <v-date-picker
                      locale="zh-cn"
                      :min="today"
                      v-model="task_date"
                      @input="$refs.task_menu_date.save(task_date)"
                    ></v-date-picker>
                  </v-menu>
                </v-flex>
                <v-flex xs4 class="AddTaskField">
                  <v-text-field
                    solo
                    v-model="newTask"
                    :error-messages="newTaskErrors"
                    @input="$v.newTask.$touch()"
                  ></v-text-field>
                </v-flex>
                <v-flex xs4 class="AddTaskField">
                  <v-select
                    hide-details solo label="分配给..." min-width="320px"
                    v-model="TaskTrustee"
                    :items="taskTrustee"
                  ></v-select>
                </v-flex>
              </v-layout>
              <v-divider class="Divider"></v-divider>
            </v-card-text>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn
                color="primary"
                @click="addTask"
              >
                添加
              </v-btn>
              <v-btn
                @click="cancleAddTask"
              >
                取消
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
      </v-navigation-drawer>
      <v-navigation-drawer
        fixed right temporary
        v-model="TeamworkSchedulePage"
      >
        <v-flex class="title">
          <span>日程</span>
        </v-flex>
        <v-divider></v-divider>
        <template v-for="schedule in schedules">
          <v-card
            flat class="Card"
            :key="schedule.schNum"
          >
            <v-tooltip bottom>
              <v-icon
                slot="activator" class="DeleteScheduleButton"
                @click="deleteSchedule(schedule.schNum)"
              >
                close
              </v-icon>
              <span>删除该项日程</span>
            </v-tooltip>
            <v-card-title>
              <v-icon>date_range</v-icon>
              <span class="ScheduleTime">{{ schedule.schTime }}</span>
            </v-card-title>
            <v-card-text>
              <span>{{ schedule.schContent }}</span>
            </v-card-text>
          </v-card>
          <v-divider :key="schedule.schContent"></v-divider>
        </template>
        <v-card
          v-if="this.userPermission == 'all'"
        >
          <v-flex>
            <v-btn
              block dark color="red darken-1"
              @click="deleteAllSchedule"
            >
              全部清除
            </v-btn>
          </v-flex>
          <v-flex>
            <v-btn
              block
              @click="showAddScheduleDialog"
            >
              添加
            </v-btn>
          </v-flex>
        </v-card>
        <v-dialog
          max-width="600px"
          v-model="addNewScheduleDialog"
        >
          <v-card>
            <v-card-title>
              <h2>添加日程</h2>
            </v-card-title>
            <v-divider></v-divider>
            <v-card-text>
              <v-layout wrap class="dateSelect">
                <v-flex xs6>
                  <v-menu
                    lazy full-width offset-y ref="schedule_menu_date" transition="scale-transition" min-width="290px"
                    v-model="schedule_menu_date"
                    :close-on-content-click="false"
                    :nudge-right="20"
                    :return-value.sync="schedule_date"
                  >
                    <v-text-field
                      readonly solo prepend-icon="event" slot="activator" class="elevation-5"
                      v-model="schedule_date"
                    ></v-text-field>
                    <v-date-picker
                      locale="zh-cn"
                      :min="today"
                      v-model="schedule_date"
                      @input="$refs.schedule_menu_date.save(schedule_date)"
                    ></v-date-picker>
                  </v-menu>
                </v-flex>
                <v-flex xs1></v-flex>
                <v-flex xs5>
                  <v-text-field
                    solo class="elevation-5"
                    v-model="thisNewSchedule"
                  ></v-text-field>
                </v-flex>
              </v-layout>
            </v-card-text>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn
                color="primary"
                @click="addNewSchedule"
              >
                添加
              </v-btn>
              <v-btn
                @click="cancleAddNewSchedule"
              >
                取消
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
      </v-navigation-drawer>
      <v-navigation-drawer
        fixed right temporary
        v-model="TeamworkGroupMemberPage"
      >
        <v-flex class="groupTitle">
          <span>讨论组成员</span>
        </v-flex>
        <v-divider></v-divider>
        <template v-for="teamworkMember in teamworkMembers">
          <v-card
            flat class="Card"
            :key="teamworkMember.groupMember"
          >
            <v-avatar
              size="60"
              @click="getGroupName(teamworkMember.groupName)"
            >
              <img :src="teamworkMember.userAvatarPath"/>
            </v-avatar>
            <span class="MemberName">{{ teamworkMember.groupMember }}</span>
            <v-icon
              class="DeleteMemberButton"
              @click="deleteMember"
            >
              close
            </v-icon>
          </v-card>
        </template>
        <v-btn
          block flat
          @click="showAddMemberDialog"
        >
          <v-icon>add</v-icon>
        </v-btn>
        <v-dialog
          max-width="450px"
          v-model="addMemberDialog"
        >
          <v-card>
            <v-card-title>
              <h2>添加成员</h2>
            </v-card-title>
            <v-divider></v-divider>
            <v-card-text>
              <v-text-field
                solo class="elevation-8"
                v-model="thisNewMember"
              ></v-text-field>
            </v-card-text>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn
                color="primary"
                @click="addNewMember"
              >
                邀请
              </v-btn>
              <v-btn
                @click="cancleAddNewMember"
              >
                取消
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
      </v-navigation-drawer>
    </v-layout>
  </v-app>
</template>

<script>
import { maxLength } from 'vuelidate/lib/validators'

export default {
  validations: {
    newGroupName: { maxLength: maxLength(15) },
    newTask: { maxLength: maxLength(20) }
  },

  data: () => ({
    drawer: true,
    drawerRight: true,
    Menu: true,
    TeamworkMenu: false,
    userPermission: '',
    CreateGroupDialog: false,
    groupNum: '',
    groupName: '',
    thisGroupAvatarPath: [],
    thisGroupNum: '',
    thisGroupName: '',
    thisGroupMember: '',
    error: false,
    newGroupName: '',
    // arr_groupName: [],
    groups: [],
    ChatWindow: false,
    GroupDetailsDialog: false,
    GroupDetails: [],
    messages: [],
    TextArea: '',

    TeamworkGroupMemberPage: false,
    teamworkMembers: [],
    addMemberDialog: false,
    thisNewMember: '',

    TeamworkSchedulePage: false,
    schedules: [],
    addNewScheduleDialog: false,
    schedule_menu_date: false,
    schedule_date: null,
    thisNewSchedule: '',

    TeamworkTaskPage: false,
    tasksForMe: [],
    tasksForElse: [],
    addTaskDialog: false,
    thatGroupName: '',
    newTask: '',
    task_menu_date: false,
    task_date: null,
    TaskTrustee: '',
    taskTrustee: []
  }),

  watch: {
    messages () {
      this.$nextTick( () => {
        var ScrollingBar = this.$el.querySelector("#Container")
        ScrollingBar.scrollTop = ScrollingBar.scrollHeight
      })
    }
  },

  mounted () {
    this.$nextTick(function () {
      this.listGroup()
    })
  },

  computed: {
    newGroupNameErrors () {
      const errors = []
      if ( !this.$v.newGroupName.$dirty ) return errors
      !this.$v.newGroupName.maxLength && errors.push('名称长度不可超过15个字')
      return errors
    },
    newTaskErrors () {
      const errors = []
      if ( !this.$v.newTask.$dirty ) return errors
      !this.$v.newTask.maxLength && errors.push('任务名称长度不可超过20个字')
      return errors
    },
    today: function () {
      var date = new Date()
      // date.setDate(date.getDate() + 1)
      var today = date.toISOString().substr(0, 10)
      return today
    }
  },

  methods: {
    listPermission () {
      var that = this

      this.axios({
        headers: { 'token': localStorage.token },
        method: 'POST',
        url: '/teamwork/listpermission',
        data: {
          "groupNum": that.groupNum
        },
        dataType: 'json'
      })
      .then(function (response) {
        that.userPermission = response.data

        that.$store.commit('saveUserPermission', response.data)
      })
      .catch(function (error) {
        console.log(error)
      })
    },
    listGroup () {
      var that = this

      this.axios({
        headers: { 'token': localStorage.token },
        method: 'GET',
        url: '/teamwork/listgroup',
        data: {},
        dataType: 'json'
      })
      .then(function (response) {
        that.groups = response.data

        console.log(response.data)

        // let arr = response.data
        // arr.forEach( (item, index) => {
        //   that.arr_groupName.push({groupName: item.groupName})
        // });

        that.$store.commit('saveGroups', response.data)
      })
      .catch(function (error) {
        console.log(error)
      })
    },
    showCreateGroupDialog () {
      this.CreateGroupDialog = true
    },
    createGroup () {
      var that = this

      this.$v.$touch()
      if ( !this.$v.$invalid ) {
        this.axios({
          headers: { 'token': localStorage.token },
          method: 'POST',
          url: '/teamwork/creategroup',
          data: {
            "groupCreateTime": that.today,
            "groupName": that.newGroupName
          },
          dataType: 'json'
        })
        .then(function (response) {
          that.newGroupName = ''
          that.CreateGroupDialog = false

          that.listTeamworkGroup()
          that.listGroup()
        })
        .catch(function (error) {
          console.log(error)
        })
      }
    },
    cancleCreateGroup () {
      this.newGroupName = ''
      this.CreateGroupDialog = !this.CreateGroupDialog
    },
    listTeamworkGroup () {
      var that = this

      this.axios({
        headers: { 'token': localStorage.token },
        method: 'GET',
        url: '/teamwork/listteamworkgroup',
        data: {},
        dataType: 'json'
      })
      .then(function (response) {
        that.thisGroupNum = response.data.groupNum
        that.thisGroupName = response.data.groupName
        that.thisGroupMember = response.data.creator

        that.createGroupManager()
      })
      .catch(function (error) {
        console.log(error)
      })
    },
    createGroupManager () {
      var that = this

      this.axios({
        headers: { 'token': localStorage.token },
        method: 'POST',
        url: '/teamwork/creategroupmanager',
        data: {
          "groupNum": that.thisGroupNum,
          "groupName": that.thisGroupName
        },
        dataType: 'json'
      })
      .then(function (response) {
        that.listGroup()
      })
      .catch(function (error) {
        console.log(error)
      })
    },
    showTeamworkPage (groupNum, groupName) {
      this.groupNum = groupNum
      this.groupName = groupName
      this.ChatWindow = true

      this.Menu = false
      this.TeamworkMenu = true

      this.listPermission()
      this.listMessage()
    },
    showGroupDetails () {
      this.GroupDetailsDialog = true

      this.groupDetails()
    },
    groupDetails () {
      var that = this

      this.axios({
        headers: { 'token': localStorage.token },
        method: 'GET',
        url: '/teamwork/' + that.groupNum + '/groupdetails',
        data: {},
        dataType: 'json'
      })
      .then(function (response) {
        that.GroupDetails = response.data
      })
      .catch(function (error) {
        console.log(error)
      })
    },
    deleteGroup () {
      var that = this

      this.axios({
        headers: { 'token': localStorage.token },
        method: 'DELETE',
        url: '/teamwork/deletegroup/' + that.groupNum,
        data: {},
        dataType: 'json'
      })
      .then(function (response) {
        that.GroupDetailsDialog = false
        that.ChatWindow = false

        that.listGroup()
      })
      .catch(function (error) {
        console.log(error)
      })
    },
    leaveGroup () {
      var that = this

      this.axios({
        headers: { 'token': localStorage.token },
        method: 'DELETE',
        url: '/teamwork/quitgroup/' + that.groupNum,
        data: {},
        dataType: 'json'
      })
      .then(function (response) {
        that.GroupDetailsDialog = false
        that.ChatWindow = false

        that.listGroup()
      })
      .catch(function (error) {
        console.log(error)
      })
    },
    listMessage () {
      var that = this

      this.axios({
        headers: { 'token': localStorage.token },
        method: 'GET',
        url: '/teamwork/' + that.groupNum + '/listmessage',
        data: {},
        dataType: 'json'
      })
      .then(function (response) {
        that.messages = response.data

        that.$store.commit('saveMessages', response.data)
      })
      .catch(function (error) {
        console.log(error)
      })
    },
    sendMessage () {
      var that = this

      var message = that.TextArea.replace(/\r\n/g, '<br />').replace(/\n/g, '<br />').replace(/\s/g, ' ')

      this.axios({
        headers: { 'token': localStorage.token },
        method: 'POST',
        url: '/teamwork/sendmessage',
        data: {
          "groupNum": that.groupNum,
          // "messTime": curTime,
          "message": message
        },
        dataType: 'json'
      })
      .then(function (response) {
        that.TextArea = ''

        that.listMessage()
      })
      .catch(function (error) {
        console.log(error)
      })
    },

    showTeamworkGroupMember () {
      this.TeamworkGroupMemberPage = true

      this.listGroupMember()
    },
    listGroupMember () {
      var that = this

      this.axios({
        headers: { 'token': localStorage.token },
        method: 'GET',
        url: '/teamwork/' + that.groupNum + '/listmember',
        data: {},
        dataType: 'json'
      })
      .then(function (response) {
        that.teamworkMembers = response.data

        let arr = response.data
        arr.forEach( (item, index) => {
          that.taskTrustee=[]
          response.data.forEach( (item, index) => {
            that.taskTrustee.push({text: item.groupMember})
          })
        })
      })
      .catch(function (error) {
        console.log(error)
      })
    },
    getGroupName (groupName) {
      this.thatGroupName = groupName
    },
    showAddMemberDialog() {
      this.addMemberDialog = !this.addMemberDialog
    },
    addNewMember () {
      var that = this

      if ( this.thisNewMember != '' ) {
        this.axios({
          headers: { 'token': localStorage.token },
          method: 'POST',
          url: '/teamwork/' + that.groupNum + '/addmember',
          data: {
            "groupName": that.thatGroupName,
            "groupMember": that.thisNewMember
          },
          dataType: 'json'
        })
        .then(function (response) {
          that.addMemberDialog = false

          that.listGroupMember()
        })
        .catch(function (error) {
          console.log(error)
        })
      }
    },
    deleteMember () {
      var that = this

      if ( this.thisNewMember != '' ) {
        this.axios({
          headers: { 'token': localStorage.token },
          method: 'DELETE',
          url: '/teamwork/' + that.groupNum + '/removemember',
          data: {
            "memberNum": that
          },
          dataType: 'json'
        })
        .then(function (response) {
        })
        .catch(function (error) {
          console.log(error)
        })
      }
    },
    cancleAddNewMember () {
      this.thisNewMember = ''
      this.addMemberDialog = false
    },
    showSchedulePage () {
      this.TeamworkSchedulePage = true

      this.listSchedule()
    },
    listSchedule () {
      var that = this

      this.axios({
        headers: { 'token': localStorage.token },
        method: 'GET',
        url: '/teamwork/' + that.groupNum + '/listschedule',
        data: {},
        dataType: 'json'
      })
      .then(function (response) {
        that.schedules = response.data
      })
      .catch(function (error) {
        console.log(error)
      })
    },
    deleteSchedule (schNum) {
      var that = this

      var thisSchNum = schNum

      this.axios({
        headers: { 'token': localStorage.token },
        method: 'DELETE',
        url: '/teamwork/' + thisSchNum + '/removeschedule',
        data: {},
        dataType: 'json'
      })
      .then(function (response) {
        that.listSchedule()
      })
      .catch(function (error) {
        console.log(error)
      })
    },
    deleteAllSchedule () {
      var that = this

      this.axios({
        headers: { 'token': localStorage.token },
        method: 'DELETE',
        url: '/teamwork/' + that.groupNum + '/removeallschedule',
        data: {},
        dataType: 'json'
      })
      .then(function (response) {
        that.listSchedule()
      })
      .catch(function (error) {
        console.log(error)
      })
    },
    showAddScheduleDialog () {
      this.addNewScheduleDialog = true
    },
    addNewSchedule () {
      var that = this

      if ( this.thisNewSchedule != '' ) {
        this.axios({
          headers: { 'token': localStorage.token },
          method: 'POST',
          url: '/teamwork/' + that.groupNum + '/addschedule',
          data: {
            "schContent": that.thisNewSchedule,
            "schTime": that.schedule_date
          },
          dataType: 'json'
        })
        .then(function (response) {
          that.thisNewSchedule = ''
          that.date = null
          that.addNewScheduleDialog = false

          that.listSchedule()
        })
        .catch(function (error) {
          console.log(error)
        })
      }
    },
    cancleAddNewSchedule () {
      this.date = null
      this.thisNewSchedule = ''
      this.addNewScheduleDialog = false
    },
    showTaskPage () {
      this.TeamworkTaskPage = true
    },
    listTaskForMe () {
      var that = this

        this.axios({
          headers: { 'token': localStorage.token },
          method: 'GET',
          url: '/teamwork/' + that.groupNum + '/listmytask',
          data: {},
          dataType: 'json'
        })
        .then(function (response) {
          that.tasksForElse = []
          that.tasksForMe = response.data
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    listTaskForElse () {
      var that = this

      this.axios({
        headers: { 'token': localStorage.token },
        method: 'GET',
        url: '/teamwork/' + that.groupNum + '/listothertask',
        data: {},
        dataType: 'json'
      })
      .then(function (response) {
        that.tasksForMe = []
        that.tasksForElse = response.data
      })
      .catch(function (error) {
        console.log(error)
      })
    },
    showAddTaskDialog () {
      this.addTaskDialog = true
    },
    addTask () {
      var that = this

      if ( !this.$v.$invalid ) {
        this.axios({
          headers: { 'token': localStorage.token },
          method: 'POST',
          url: '/teamwork/' + that.groupNum + '/addtask',
          data: {
            "taskCreateTime": that.task_date,
            "taskContent": that.newTask,
            "taskTrustee": that.TaskTrustee.text
          },
          dataType: 'json'
        })
        .then(function (response) {
          that.task_menu_date = false
          that.task_date = null
          that.newTask = ''
          that.TaskTrustee = null
          that.addTaskDialog = false

          that.listTaskForMe()
          that.listTaskForElse()
        })
        .catch(function (error) {
          console.log(error)
        })
      }
    },
    cancleAddTask () {
      this.task_menu_date = false
      this.task_date = null
      this.newTask = ''
      this.TaskTrustee = null
      this.addTaskDialog = false
    },
    finishTask (taskNum) {
      var that = this

      var thisTaskNum = taskNum

      this.axios({
          headers: { 'token': localStorage.token },
          method: 'PATCH',
          url: '/teamwork/' + thisTaskNum + '/finishtask',
          data: {},
          dataType: 'json'
        })
        .then(function (response) {
          that.listTaskForMe()
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    deleteTask (taskNum) {
      var that = this

      var thisTaskNum = taskNum

      this.axios({
          headers: { 'token': localStorage.token },
          method: 'DELETE',
          url: '/teamwork/' + thisTaskNum + '/removetask',
          data: {},
          dataType: 'json'
        })
        .then(function (response) {
          that.listTaskForMe()
        })
        .catch(function (error) {
          console.log(error)
        })
    }
  },

  props: {
    source: String
  },
}
</script>

<style scoped>
.gap {
  margin-bottom: 15px;
}
.Group {
  height: 80px;
}
.Group:hover {
  background: #E0E0E0;
  cursor: pointer;
}
.GroupAvatar {
  margin-left: 15px;
  margin-top: 16px;
}
.GroupName {
  margin-top: 29px;
  font-size: 15px;
}
.space {
  margin-bottom: 2px;
}
.TheChatWindow {
  width: 100%;
  overflow-y: scroll;
}
.GroupDetails:hover {
  cursor: pointer;
  text-decoration: underline;
}
.MessageBox {
  position: relative;
  top: 18px;
  left: 20px;
  height: auto;
  max-width: 500px;

  background: #039BE5;

  font-size: 15px;
  color: #ffffff;

  border: 1px solid;
  border-radius: 10px;

  display: inline-block;
}
.Message {
  margin-top: 8px;
  margin-bottom: 8px;
  margin-left: 15px;
  margin-right: 15px;

  float: left;
}
.DetailsGap {
  margin-top: 10px;
  margin-bottom: 30px;
}
.DetailsTitle {
  margin-bottom: 20px;
  font-size: 15px;
}
.DetailsContent {
  margin-left: 15px;
  font-size: 15px;
}
.Divider {
  margin-top: 20px;
  margin-bottom: 5px;
}
.groupTitle {
  margin-top: 10px;
  margin-left: 120px;
  margin-bottom: 10px;
  font-size: 18px;
}
.title {
  margin-top: 10px;
  margin-left: 140px;
  margin-bottom: 10px;
}
.Card {
  margin-top: 10px;
  margin-left: 10px;
}
.MemberName {
  margin-left: 10px;
  font-size: 15px;
}
.DeleteMemberButton {
  position: absolute;
  top: 20px;
  right: 20px;

  opacity: 0;
}
.DeleteMemberButton:hover {
  opacity: 1;
}
.ScheduleTime {
  margin-left: 10px;
}
.DeleteScheduleButton {
  margin-left: 250px;
}
.dateSelect {
  margin-bottom: 10px;
}
.TeamworkPageTopButton {
  margin-top: 10px;
  margin-bottom: 10px;
  margin-left: 20px;
}
.AddTaskField {
  margin-left: 10px;
  margin-right: 10px;
}
.TaskContentContainer {
  margin-top: 10px;
  margin-left: 10px;
  margin-bottom: 20px;
}
.TaskContent {
  margin-left: 85px;
}
.ElseTaskContent {
  margin-left: 38px;
}
.TaskButton {
  margin-left: 68px;
  margin-right: 10px;
  cursor: pointer;
}
</style>
