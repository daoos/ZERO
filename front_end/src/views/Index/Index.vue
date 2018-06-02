<template>
  <v-app id="inspire">
    <v-navigation-drawer
      app fixed
      v-model="drawer"
      :clipped="$vuetify.breakpoint.lgAndUp"
    >
      <v-list dense>
        <template v-for="item in items">
          <v-list-group
            v-model="item.model1"
            v-if="item.children1"
            :key="item.text1"
            :prepend-icon="item.model1 ? item.icon1 : item['icon-alt1']"
            append-icon=""
          >
            <v-list-tile slot="activator">
              {{ item.text1 }}
            </v-list-tile>
            <v-list-tile
              v-for="(child, invNum) in item.children1"
              :key="invNum"
              @click="inventoryItem(child.invTitle)"
            >
              <v-list-tile-content>
                {{ child.invTitle }}
              </v-list-tile-content>
              <v-list-tile-action class="ma-0">
                <v-icon
                  class="invButton ma-0"
                  @click="modifyInv(child.invNum, child.invTitle)">more_horiz</v-icon>
              </v-list-tile-action>
              <v-dialog
                max-width="500px"
                v-model="modifyInvDialog"
              >
                <v-card>
                  <v-toolbar dark color="primary">
                    <h2 class="mx-auto">更改清单名称</h2>
                  </v-toolbar>
                  <v-alert
                    dismissible transition="scale-transition" type="error"
                    v-model="invAlert1"
                  >
                    键入内容不可为空或包含空格
                  </v-alert>
                  <v-alert
                    dismissible transition="scale-transition" type="error"
                    v-model="invAlert2"
                  >
                    新清单名称不可与原有的相同
                  </v-alert>
                  <v-card-text>
                    <v-text-field
                      solo class="elevation-8"
                      v-model="newInvTitle"
                      :label="pastInvTitle"
                      :counter="15"
                      :error-messages="newInvTitleInputErrors"
                      @input="$v.newInvTitle.$touch()"
                      @blur="$v.newInvTitle.$touch()"
                    ></v-text-field>
                  </v-card-text>
                  <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn
                      @click="saveInvChange(child.invNum, child.invTitle)"
                    >
                      更改
                    </v-btn>
                    <v-btn
                      @click="closeModifyInvDialog"
                    >
                      取消
                    </v-btn>
                  </v-card-actions>
                </v-card>
              </v-dialog>
              <v-list-tile-action>
                <v-icon
                  class="invButton"
                  @click="deleteInv(child.invNum)">close</v-icon>
              </v-list-tile-action>
              <v-dialog
                max-width="300px"
                v-model="deleteInvDialog"
              >
                <v-card>
                    <v-alert :value="true" type="error">
                      是否确认删除该清单项目?
                    </v-alert>
                  <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn
                      @click="confirmDelInv(child.invNum)"
                    >
                      确定
                    </v-btn>
                    <v-btn
                      @click="cancleDelInv"
                    >
                      取消
                    </v-btn>
                  </v-card-actions>
                </v-card>
              </v-dialog>
            </v-list-tile>
            <v-form>
              <v-flex v-show="showAddInventory">
                <v-alert
                  dismissible transition="scale-transition" type="error"
                  v-model="alert"
                >
                  该清单已存在
                </v-alert>
                <v-text-field
                  solo-inverted
                  v-model="content"
                  :counter="15"
                  :error-messages="inventoryInputErrors"
                  @input="$v.content.$touch()"
                  @blur="$v.content.$touch()"
                ></v-text-field>
                <v-flex class="Button">
                  <v-btn dark class="grey darken-3" @click="addInventory">保存</v-btn>
                  <v-btn @click="clearInvContent">取消</v-btn>
                </v-flex>
              </v-flex>
              <v-flex>
                <v-btn
                  flat block small
                  @click="showAddInventory = true"
                >
                  <v-icon>add</v-icon>
                </v-btn>
              </v-flex>
            </v-form>
          </v-list-group>
          <v-list-group
            v-model="item.model2"
            v-else-if="item.children2"
            :key="item.text2"
            :prepend-icon="item.model2 ? item.icon2 : item['icon-alt2']"
            append-icon=""
          >
            <v-list-tile slot="activator">
              {{ item.text2 }}
            </v-list-tile>
            <v-list-tile
              v-for="(child, i2) in item.children2"
              :key="i2"
              @click="filterItem(child.i2)"
            >
              <v-list-tile-action v-if="child.icon2">
                <v-icon>{{ child.icon2 }}</v-icon>
              </v-list-tile-action>
              <v-list-tile-content>
                {{ child.text2 }}
              </v-list-tile-content>
            </v-list-tile>
          </v-list-group>
          <v-list-tile v-else :key="item.text" @click="itemName(item.id)" >
            <v-list-tile-action>
              <v-icon>{{ item.icon }}</v-icon>
            </v-list-tile-action>
            <v-list-tile-content>
              {{ item.text }}
            </v-list-tile-content>
          </v-list-tile>
        </template>
      </v-list>
    </v-navigation-drawer>
    <v-toolbar
      app dark fixed color="blue darken-3"
      :clipped-left="$vuetify.breakpoint.lgAndUp"
    >
      <v-toolbar-title class="ml-0 pl-3" style="width: 300px">
        <v-toolbar-side-icon @click.stop="drawer = !drawer"></v-toolbar-side-icon>
        <span class="hidden-sm-and-down">Zero</span>
      </v-toolbar-title>
      <v-text-field
        flat solo-inverted prepend-icon="search" class="hidden-sm-and-down" label="快速查找"
        v-model="SearchBar"
        @keyup.enter="search"
      ></v-text-field>
      <v-spacer></v-spacer>
      <v-progress-circular indeterminate color="white" v-show="Progress" :width="4" :size="25"></v-progress-circular>
      <span class="Spacer"></span>
      <v-btn icon @click="Dialog = !Dialog">
        <v-badge
          overlap right color="red"
          v-model="Badge"
        >
          <span slot="badge"><v-icon small>priority_high</v-icon></span>
            <v-icon medium>notifications</v-icon>
        </v-badge>
      </v-btn>
      <v-dialog scrollable max-width="450px" v-model="Dialog">
        <v-card>
          <v-card-title>
            <h2>通知</h2>
            <v-spacer></v-spacer>
            <v-btn
              flat small
              @click="readAllNotification"
            >
              全部标记为已读
            </v-btn>
          </v-card-title>
          <v-divider></v-divider>
          <v-card-text style="height: 350px;">
            <v-list two-line>
              <template v-for="Notification in Notifications">
                <v-list-tile
                  :key="Notification.noticeNum"
                  @click="readNotification(Notification.noticeNum)">
                  <v-list-tile-avatar>
                    <img src="../../assets/pictures/Avatar/Vuetify.png">
                  </v-list-tile-avatar>
                  <v-list-tile-content>
                    <v-list-tile-title
                      v-html="Notification.noticeTitle"
                    >
                    </v-list-tile-title>
                    <v-list-tile-sub-title
                      v-html="Notification.noticeContent"
                    ></v-list-tile-sub-title>
                  </v-list-tile-content>
                  <v-btn
                    flat icon
                    v-if="Notification.noticeRead == 'N'"
                  >
                    <v-icon
                      color="red"
                      :key="Notification.noticeNum"
                    >
                      fiber_manual_record
                    </v-icon>
                  </v-btn>
                </v-list-tile>
                <v-divider
                  :key="Notification.index"
                ></v-divider>
              </template>
            </v-list>
          </v-card-text>
          <v-divider></v-divider>
          <v-card-actions>
            <router-link to="/teamwork">
              <v-btn block outline class="TeamworkButton mx-auto">进入团队协作界面</v-btn>
            </router-link>
          </v-card-actions>
        </v-card>
      </v-dialog>
      <v-menu offset-y>
        <v-btn dark icon medium slot="activator">
          <v-icon medium>settings</v-icon>
        </v-btn>
        <v-list>
          <v-list-tile v-for="(menu, index) in menus" :key="index" @click="dropdownMenu(index)">
            <span><v-icon>{{ menu.icon }}</v-icon></span>
            <span class="Menu">{{ menu.text }}</span>
          </v-list-tile>
        </v-list>
      </v-menu>
    </v-toolbar>
    <v-content>
      <router-view />

      <v-container
        fluid
        v-show="InvPage"
      >
        <v-layout class="gap">
          <v-flex>
            <h2>{{ this.theInvTitle }}</h2>
          </v-flex>
        </v-layout>
        <v-layout
            class="gap"
            v-if="!this.expiredTodoItemsByInv.length == 0"
          >
            <v-flex>
              <h4 class="Expired">已过期</h4>
              <v-divider></v-divider>
              <template v-for="expiredTodoItemByInv in expiredTodoItemsByInv">
                <v-card
                  v-if="expiredTodoItemByInv.isShow"
                  :key="expiredTodoItemByInv.todoNum"
                >
                  <v-toolbar>
                    <v-icon v-if="expiredTodoItemByInv.priorityLevel == 'p3'">looks_3</v-icon>
                    <v-icon v-else-if="expiredTodoItemByInv.priorityLevel == 'p2'">looks_two</v-icon>
                    <v-icon v-else-if="expiredTodoItemByInv.priorityLevel == 'p1'">looks_one</v-icon>
                    <v-icon v-else>indeterminate_check_box</v-icon>

                    <v-flex class="CheckBox">
                      <v-checkbox
                        value
                        @click="finishExpiredTodoByInv(expiredTodoItemByInv)"
                      ></v-checkbox>
                    </v-flex>

                    <span>{{ expiredTodoItemByInv.todoContent }}</span>

                    <v-spacer></v-spacer>

                    <v-flex
                      class="Inventory"
                      v-if="expiredTodoItemByInv.invTitle != '无'"
                    >
                      <v-icon>bookmark</v-icon>
                      <span>{{ expiredTodoItemByInv.invTitle }}</span>
                    </v-flex>
                  </v-toolbar>
                </v-card>
              </template>
            </v-flex>
          </v-layout>
          <v-layout class="gap">
            <v-flex>
              <v-flex
                v-if="!this.todoItemsByInv.length == 0"
              >
                <span><b>进行中</b></span>
              </v-flex>
              <v-divider></v-divider>
              <template v-for="todoItemByInv in todoItemsByInv">
                <v-card
                  v-if="todoItemByInv.isShow"
                  :key="todoItemByInv.todoNum"
                >
                  <v-toolbar>
                    <v-icon v-if="todoItemByInv.priorityLevel == 'p3'">looks_3</v-icon>
                    <v-icon v-else-if="todoItemByInv.priorityLevel == 'p2'">looks_two</v-icon>
                    <v-icon v-else-if="todoItemByInv.priorityLevel == 'p1'">looks_one</v-icon>
                    <v-icon v-else>indeterminate_check_box</v-icon>

                    <v-flex class="CheckBox">
                      <v-checkbox
                        value
                        @click="finishTodoByInv(todoItemByInv)"
                      ></v-checkbox>
                    </v-flex>

                    <span>{{ todoItemByInv.todoContent }}</span>

                    <v-spacer></v-spacer>

                    <v-flex
                      class="Inventory"
                      v-if="todoItemByInv.invTitle != '无'"
                    >
                      <v-icon>bookmark</v-icon>
                      <span>{{ todoItemByInv.invTitle }}</span>
                    </v-flex>
                  </v-toolbar>
                </v-card>
              </template>
            </v-flex>
          </v-layout>
          <v-snackbar
            :timeout="timeout"
            :bottom="'bottom'"
            v-model="snackbarExpiredByInv"
          >
            完成一条待办事项
            <v-btn
              flat color="pink"
              @click="revokeExpiredFinishedByInv"
            >
              撤销
            </v-btn>
          </v-snackbar>
          <v-snackbar
            :timeout="timeout"
            :bottom="'bottom'"
            v-model="snackbarByInv"
          >
            完成一条待办事项
            <v-btn
              flat color="pink"
              @click="revokeFinishedByInv"
            >
              撤销
            </v-btn>
          </v-snackbar>
      </v-container>

      <v-container
        fluid
        v-show="SearchPage"
      >
        <v-layout class="gap">
          <v-flex>
            <h2>快速搜索</h2>
          </v-flex>
        </v-layout>
        <v-layout
            class="gap"
            v-if="!this.searchExpiredTodoItems.length == 0"
          >
            <v-flex>
              <h4 class="Expired">已过期</h4>
              <v-divider></v-divider>
              <template v-for="searchExpiredTodoItem in searchExpiredTodoItems">
                <v-card
                  v-if="searchExpiredTodoItem.isShow"
                  :key="searchExpiredTodoItem.todoNum"
                >
                  <v-toolbar>
                    <v-icon v-if="searchExpiredTodoItem.priorityLevel == 'p3'">looks_3</v-icon>
                    <v-icon v-else-if="searchExpiredTodoItem.priorityLevel == 'p2'">looks_two</v-icon>
                    <v-icon v-else-if="searchExpiredTodoItem.priorityLevel == 'p1'">looks_one</v-icon>
                    <v-icon v-else>indeterminate_check_box</v-icon>

                    <v-flex class="CheckBox">
                      <v-checkbox
                        value
                        @click="finishSearchExpiredTodo(searchExpiredTodoItem)"
                      ></v-checkbox>
                    </v-flex>

                    <span>{{ searchExpiredTodoItem.todoContent }}</span>

                    <v-spacer></v-spacer>

                    <v-flex
                      class="Inventory"
                      v-if="searchExpiredTodoItem.invTitle != '无'"
                    >
                      <v-icon>bookmark</v-icon>
                      <span>{{ searchExpiredTodoItem.invTitle }}</span>
                    </v-flex>
                  </v-toolbar>
                </v-card>
              </template>
            </v-flex>
          </v-layout>
          <v-layout
            class="gap"
            v-if="!this.searchTodoItems.length == 0"
          >
            <v-flex>
              <v-flex>
                <span><b>进行中</b></span>
              </v-flex>
              <v-divider></v-divider>
              <template v-for="searchTodoItem in searchTodoItems">
                <v-card
                  v-if="searchTodoItem.isShow"
                  :key="searchTodoItem.todoNum"
                >
                  <v-toolbar>
                    <v-icon v-if="searchTodoItem.priorityLevel == 'p3'">looks_3</v-icon>
                    <v-icon v-else-if="searchTodoItem.priorityLevel == 'p2'">looks_two</v-icon>
                    <v-icon v-else-if="searchTodoItem.priorityLevel == 'p1'">looks_one</v-icon>
                    <v-icon v-else>indeterminate_check_box</v-icon>

                    <v-flex class="CheckBox">
                      <v-checkbox
                        value
                        @click="finishSearchTodo(searchTodoItem)"
                      ></v-checkbox>
                    </v-flex>

                    <span>{{ searchTodoItem.todoContent }}</span>

                    <v-spacer></v-spacer>

                    <v-flex
                      class="Inventory"
                      v-if="searchTodoItem.invTitle != '无'"
                    >
                      <v-icon>bookmark</v-icon>
                      <span>{{ searchTodoItem.invTitle }}</span>
                    </v-flex>
                  </v-toolbar>
                </v-card>
              </template>
            </v-flex>
          </v-layout>
          <v-layout
            class="gap"
            v-if="this.searchExpiredTodoItems.length == 0 && this.searchTodoItems.length == 0"
          >
            <v-flex>
              <v-flex>
                <span><h3>该待办事项条目不存在</h3></span>
              </v-flex>
            </v-flex>
          </v-layout>
        <v-snackbar
          :timeout="timeout"
          :bottom="'bottom'"
          v-model="searchSnackbar"
        >
          完成一条待办事项
          <v-btn
            flat color="pink"
            @click="revokeSearchFinished"
          >
            撤销
          </v-btn>
        </v-snackbar>
        <v-snackbar
          :timeout="timeout"
          :bottom="'bottom'"
          v-model="searchExpiredSnackbar"
        >
          完成一条待办事项
          <v-btn
            flat color="pink"
            @click="revokeSearchExpiredFinished"
          >
            撤销
          </v-btn>
        </v-snackbar>
      </v-container>
    </v-content>
  </v-app>
</template>

<script>
import Memorandum from './Memorandum'
import Today from './Today'
import SevenDays from './SevenDays'
import Finished from './Finished'
import Filter1 from '../../components/Filter/Filter1'
import Filter2 from '../../components/Filter/Filter2'
import Filter3 from '../../components/Filter/Filter3'

import { maxLength, required } from 'vuelidate/lib/validators'

export default {
  validations: {
    content: { maxLength: maxLength(15), required },
    newInvTitle: { maxLength: maxLength(15) }
  },

  components: {
    Memorandum,
    Today,
    SevenDays,
    Finished,
    Filter1,
    Filter2,
    Filter3
  },

  data: () => ({
    drawer: null,
    Badge: false,
    Dialog: false,
    Progress: false,
    showAddInventory: false,
    alert: false,
    content: '',
    AddList: false,
    modifyInvDialog: false,
    invAlert1: false,
    invAlert2: false,
    theInvNum1: '',
    theInvNum2: '',
    pastInvTitle: '',
    newInvTitle: '',
    deleteInvDialog: false,
    isTrue: false,
    isFalse: true,
    name: '',
    InvPage: false,
    theInvNum: '',
    theInvTitle: '',
    snackbar: false,
    timeout: 3000,
    setTime: null,
    todoNum: '',
    expiredTodoNum: '',
    todoItemsByInv: [],
    expiredTodoItemsByInv: [],
    snackbarByInv: false,
    snackbarExpiredByInv: false,
    SearchBar: '',
    SearchPage: false,
    searchTodoItems: [],
    searchExpiredTodoItems: [],
    searchExpiredSnackbar: false,
    searchSnackbar: false,
    NoticesUnread: '',
    Notifications: [],
    menus: [
      { icon: 'cached', text: '同步' },
      { icon: 'settings', text: '设置' },
      { icon: 'exit_to_app', text: '注销账户' },
    ],
    items: [
      { id: 0, icon: 'book', text: '备忘录' },
      { id: 1, icon: 'today', text: '今天' },
      { id: 2, icon: 'filter_7', text: '未来7天' },
      { id: 3, icon: 'assignment', text: '已完成' },
      {
        icon1: 'keyboard_arrow_up',
        'icon-alt1': 'keyboard_arrow_down',
        text1: '清单',
        model1: false,
        children1: []
      },
      {
        icon2: 'keyboard_arrow_up',
        'icon-alt2': 'keyboard_arrow_down',
        text2: '过滤器',
        model2: false,
        children2: [
          { i2: 0, icon2: 'looks_one', text2: '优先级1' },
          { i2: 1, icon2: 'looks_two', text2: '优先级2' },
          { i2: 2, icon2: 'looks_3', text2: '优先级3' },
        ]
      }
    ]
  }),

  mounted () {
    this.$nextTick(function () {
      this.findInventory(),
      this.getNotice(),
      this.getNoticeUnread()
    })
  },

  computed: {
    // badge () {
    //   return this.Badge ? this.badgeData : null
    // },
    inventoryInputErrors () {
      const errors = []
      if ( !this.$v.content.$dirty ) return errors
      !this.$v.content.required && errors.push('清单内容不可为空')
      !this.$v.content.maxLength && errors.push('清单内容长度不可超过15')
      return errors
    },
    newInvTitleInputErrors () {
      const errors = []
      if ( !this.$v.newInvTitle.$dirty ) return errors
      !this.$v.newInvTitle.maxLength && errors.push('清单内容长度不可超过15')
      return errors
    }
  },

  methods: {
    dropdownMenu (index) {
      var that = this

      switch (index)
      {
        case 0:
          this.Progress = true
          setTimeout( () => {
            this.Progress = false
          }, 5000)
          break;
        case 1:
          this.$router.push('/setting')
          break;
        default:
          that.$store.commit('logout')
          this.$router.push('/welcome')
          break;
      }
    },
    itemName (id) {
      switch (id)
      {
        case 0:
          this.InvPage = false
          this.SearchPage = false
          this.$router.push('/memorandum')
          break;
        case 1:
          this.InvPage = false
          this.SearchPage = false
          this.$router.push('/today')
          break;
        case 2:
          this.InvPage = false
          this.SearchPage = false
          this.$router.push('/sevendays')
          break;
        default:
          this.InvPage = false
          this.SearchPage = false
          this.$router.push('/finished')
          break;
      }
    },
    inventoryItem (invTitle) {
      this.theInvTitle = invTitle

      this.findtodobyinv()
      this.findexpiredtodobyinv()

      this.$router.push('/index')
      this.InvPage = true
      this.SearchPage = false
    },
    filterItem (i2) {
      switch (i2)
      {
        case 0:
          this.InvPage = false
          this.SearchPage = false
          this.$router.push('/filter1')
          break;
        case 1:
          this.InvPage = false
          this.SearchPage = false
          this.$router.push('/filter2')
          break;
        default:
          this.InvPage = false
          this.SearchPage = false
          this.$router.push('/filter3')
          break;
      }
    },
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
        that.items.forEach( (x, index) => {
          if ( x.hasOwnProperty('text1') ) {
            x.children1 = response.data
          }
        })

        let obj = {}
        for ( var i in response.data ) {
          obj[i] = response.data[i]
        }
        that.name = obj[i].invTitle

        that.$store.commit('saveInventory', response.data)
      })
      .catch(function (error) {
        console.log(error)
      })
    },
    getNotice () {
      var that = this

      this.axios({
        headers: { 'token': localStorage.token },
        method: 'GET',
        url: '/user/getnotice',
        data: {},
        dataType: 'json'
      })
      .then(function (response) {
        that.Notifications = response.data
      })
      .catch(function (error) {
        console.log(error)
      })
    },
    getNoticeUnread () {
      var that = this

      this.axios({
        headers: { 'token': localStorage.token },
        method: 'GET',
        url: '/user/getnoticeunread',
        data: {},
        dataType: 'json'
      })
      .then(function (response) {
        that.NotificationsBadge(response.data[0])
      })
      .catch(function (error) {
        console.log(error)
      })
    },
    NotificationsBadge (unreadNum) {
      if ( unreadNum > 0 ) {
        this.Badge = true
      }
      else {
        this.Badge = false
      }
    },
    readNotification(noticeNum) {
      var that = this

      this.axios({
        headers: { 'token': localStorage.token },
        method: 'PATCH',
        url: '/user/readnotice/' + noticeNum,
        data: {},
        dataType: 'json'
      })
      .then(function (response) {
        that.getNotice()
        that.getNoticeUnread()
      })
      .catch(function (error) {
        console.log(error)
      })
    },
    readAllNotification () {
      var that = this

      this.axios({
        headers: { 'token': localStorage.token },
        method: 'PATCH',
        url: '/user/readallnotice',
        data: {},
        dataType: 'json'
      })
      .then(function (response) {
        that.getNotice()
        that.getNoticeUnread()
      })
      .catch(function (error) {
        console.log(error)
      })
    },
    findexpiredtodobyinv () {
      var that = this

      var invTitle = this.theInvTitle

      this.axios({
        headers: { 'token': localStorage.token },
        method: 'POST',
        url: '/todo/findexpiredtodobyinv',
        data: {
          "invTitle": invTitle
        },
        dataType: 'json'
      })
      .then(function (response) {
        that.expiredTodoItemsByInv=[]
        response.data.forEach( (item,index) => {
          that.expiredTodoItemsByInv.push({
            isShow: true, ...item
          })
        })

        that.$store.commit('saveTodo', response.data)
      })
      .catch(function (error) {
        console.log(error)
      })
    },
    findtodobyinv () {
      var that = this

      var invTitle = this.theInvTitle

      this.axios({
        headers: { 'token': localStorage.token },
        method: 'POST',
        url: '/todo/findtodobyinv',
        data: {
          "invTitle": invTitle
        },
        dataType: 'json'
      })
      .then(function (response) {
        that.todoItemsByInv=[]
        response.data.forEach( (item,index) => {
          that.todoItemsByInv.push({
            isShow: true, ...item
          })
        })

        that.$store.commit('saveTodo', response.data)
      })
      .catch(function (error) {
        console.log(error)
      })
    },
    searchExpiredTodo () {
      var that = this

      this.axios({
        headers: { 'token': localStorage.token },
        method: 'POST',
        url: '/todo/searchexpiredtodo',
        data: {
          "todoContent": this.SearchBar
        },
        dataType: 'json'
      })
      .then(function (response) {
        that.searchExpiredTodoItems=[]
        response.data.forEach( (item,index) => {
          that.searchExpiredTodoItems.push({
            isShow: true, ...item
          })
        })
      })
      .catch(function (error) {
        console.log(error)
      })
    },
    searchTodo () {
      var that = this

      this.axios({
        headers: { 'token': localStorage.token },
        method: 'POST',
        url: '/todo/searchtodo',
        data: {
          "todoContent": that.SearchBar
        },
        dataType: 'json'
      })
      .then(function (response) {
        that.searchTodoItems=[]
        response.data.forEach( (item,index) => {
          that.searchTodoItems.push({
            isShow: true, ...item
          })
        })
      })
      .catch(function (error) {
        console.log(error)
      })
    },
    addInventory () {
      if ( this.content == this.name ) {
        this.alert = true
      }
      else {
        var that = this

        this.axios({
          headers: { 'token': localStorage.token },
          method: 'POST',
          url: '/inventory/add',
          data: {
            "invTitle": this.content
          },
          dataType: 'json'
        })
        .then(function (response) {
          that.content = ''
          that.showAddInventory = false

          that.$router.go(0)
          // that.findInventory()
        })
        .catch(function (error) {
          console.log(error)
        })
      }
    },
    clearInvContent () {
      this.content = ''
      this.showAddInventory = false
    },
    modifyInv (invNum,invTitle) {
      this.modifyInvDialog = true
      this.theInvNum1 = invNum
      this.pastInvTitle = invTitle
    },
    saveInvChange (invNum, invTitle) {
      if ( this.newInvTitle == '' || this.newInvTitle.indexOf("") >= 0 ) {
        this.invAlert2 = false
        this.invAlert1 = true
      }
      else if ( this.newInvTitle != invTitle ) {
        var that = this

        this.axios({
          headers: { 'token': localStorage.token },
          method: 'PATCH',
          url: '/inventory/modify',
          data: {
            "invNum": this.theInvNum1,
            "invTitle": this.newInvTitle
          },
          dataType: 'json'
        })
        .then(function (response) {
          that.pastInvTitle = ''
          that.modifyInvDialog = false
          that.findInventory()
        })
        .catch(function (error) {
          console.log(error)
        })
      }
      else {
        this.invAlert1 = false
        this.invAlert2 = true
      }
    },
    closeModifyInvDialog () {
      this.invAlert1 = false
      this.invAlert2 = false
      this.modifyInvDialog = false
    },
    deleteInv (invNum) {
      this.theInvNum2 = invNum
      this.deleteInvDialog = true
    },
    confirmDelInv (invNum) {
      var that = this

      this.axios({
        headers: { 'token': localStorage.token },
        method: 'DELETE',
        url: '/inventory/delete',
        data: {
          "invNum": this.theInvNum2,
        },
        dataType: 'json'
      })
      .then(function (response) {
        that.deleteInvDialog = false

        that.InvPage = false
        that.findInventory()
      })
      .catch(function (error) {
        console.log(error)
      })
    },
    cancleDelInv () {
      this.deleteInvDialog = false
    },
    finishExpiredTodoByInv (todoNum) {
      this.todoNum = todoNum

      todoNum.isShow = false
      this.snackbarByInv = true

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
          that.findexpiredtodobyinv()
        })
        .catch(function (error) {
          console.log(error)
        })
      }, 3000);
    },
    revokeExpiredFinishedByInv () {
      this.snackbarExpiredByInv = false
      this.todoNum.isShow = true

      clearTimeout(this.setTime)
    },
    finishTodoByInv (todoNum) {
      this.todoNum = todoNum

      todoNum.isShow = false
      this.snackbarByInv = true

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
          that.findexpiredtodobyinv()
        })
        .catch(function (error) {
          console.log(error)
        })
      }, 3000);
    },
    revokeFinishedByInv () {
      this.snackbarByInv = false
      this.todoNum.isShow = true

      clearTimeout(this.setTime)
    },
    search () {
      this.$router.push('/index')
      this.SearchPage = true
      this.InvPage = false

      this.searchTodo()
      this.searchExpiredTodo()
    },
    finishSearchExpiredTodo (todoNum) {
      this.expiredTodoNum = todoNum

      todoNum.isShow = false
      this.searchExpiredSnackbar = true

      this.setTime = setTimeout(() => {
        var that = this

        this.axios({
          headers: { 'token': localStorage.token },
          method: 'PATCH',
          url: '/todo/finish' + '/' +  this.expiredTodoNum.todoNum,
          data: {},
          dataType: 'json'
        })
        .then(function (response) {
          that.searchTodo()
        })
        .catch(function (error) {
          console.log(error)
        })
      }, 3000);
    },
    revokeSearchExpiredFinished () {
      this.searchExpiredSnackbar = false
      this.expiredTodoNum.isShow = true

      clearTimeout(this.setTime)
    },
    finishSearchTodo (todoNum) {
      this.todoNum = todoNum

      todoNum.isShow = false
      this.searchSnackbar = true

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
          that.searchTodo()
        })
        .catch(function (error) {
          console.log(error)
        })
      }, 3000);
    },
    revokeSearchFinished () {
      this.searchSnackbar = false
      this.todoNum.isShow = true

      clearTimeout(this.setTime)
    }
  },

  props: {
    source: String
  }
}
</script>

<style scoped>
a {
  text-decoration: none;
}
hr {
  margin-top: 10px;
}
.gap {
  margin-bottom: 30px;
}
.Spacer {
  width: 15px;
}
.Menu {
  margin-left: 15px;
  width: 120px;
}
.Button {
  margin-left: 45px;
}
.Read {
  font-weight: normal;
}
.notRead {
  font-weight: bold;
}
.TeamworkButton {
  width: 430px;
}
.invButton {
  margin-right: 20px;
  opacity: 0;
}
.invButton:hover {
  opacity:1;
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
