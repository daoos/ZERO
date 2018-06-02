<template>
  <v-app id="inspire">
    <v-container fluid>
      <v-layout class="gap">
        <v-flex>
          <h2>发布公告</h2>
        </v-flex>
      </v-layout>
      <v-divider></v-divider>
      <v-card>
        <v-card-title>
          <v-flex xs3>
            <v-select
              single-line solo label="发送至..."
              v-model="NoticeReceiver"
              :items="Users"
            ></v-select>
          </v-flex>
          <v-flex xs1></v-flex>
          <v-flex xs8>
            <v-text-field
              solo label="请键入公告标题..."
              v-model="NoticeTitle"
            ></v-text-field>
          </v-flex>
        </v-card-title>
        <v-card-text>
          <v-text-field
            textarea no-resize label="请键入公告内容..."
            v-model="TextArea"
          ></v-text-field>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn
            color="success"
            @click="sendAnnouncement"
          >
            发送
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-container>
  </v-app>
</template>

<script>
export default {
  data: () => ({
    Users: [],
    NoticeReceiver: null,
    NoticeTitle: '',
    TextArea: ''
  }),

  mounted () {
    this.$nextTick(function () {
      this.findAllUser()
    })
  },

  computed: {
    Today: function () {
      var date = new Date()
      // date.setDate(date.getDate() + 1)
      var today = date.toISOString().substr(0, 10)
      return today
    }
  },

  methods: {
    findAllUser () {
      var that = this

      this.axios({
        method: 'GET',
        url: '/manager/findalluser',
        data: {},
        dataType: 'json'
      })
      .then(function (response) {
        let arr = response.data
        arr.forEach( (item, index) => {
          that.Users.push({text: item.userEmail})
        })
      })
      .catch(function (error) {
        console.log(error)
      })
    },
    sendAnnouncement () {
      var that = this

      var thisToday = new Date(this.Today)
      var message = that.TextArea.replace(/\r\n/g, '<br />').replace(/\n/g, '<br />').replace(/\s/g, ' ')

      this.axios({
        headers: { 'token': localStorage.manager_token },
        method: 'POST',
        url: '/manager/sendnotice',
        data: {
          "noticeSendTime": thisToday,
          "noticeReceiver": that.NoticeReceiver.text,
          "noticeTitle": that.NoticeTitle,
          "noticeContent": message
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
}
</script>

<style scoped>
hr {
  margin-top: 5px;
  margin-bottom: 8px;
}
.gap {
  margin-bottom: 20px;
}
</style>
