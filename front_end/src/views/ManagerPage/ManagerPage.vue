<template>
  <v-app id="inspire">
    <v-navigation-drawer
      v-model="drawer"
      fixed
      app
    >
      <v-list dense>
        <v-list-tile @click="TurnToUserManagerPage">
          <v-list-tile-action>
            <v-icon>people_outline</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title>用户管理</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>
        <v-list-tile @click="TurnToAnnouncementPage">
          <v-list-tile-action>
            <v-icon>send</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title>发布公告</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>
        <v-list-tile @click="TurnToSystemManagePage">
          <v-list-tile-action>
            <v-icon>dns</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title>系统维护</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>
        <v-list-tile @click="Exit">
          <v-list-tile-action>
            <v-icon>exit_to_app</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title>退出</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>
      </v-list>
    </v-navigation-drawer>
    <v-toolbar color="light-green darken-1" dark fixed app>
      <v-toolbar-side-icon @click.stop="drawer = !drawer"></v-toolbar-side-icon>
      <v-toolbar-title>系统管理员操作界面</v-toolbar-title>
    </v-toolbar>
    <v-content>
      <router-view />
    </v-content>
  </v-app>
</template>

<script>
import UserManager from '../../components/ManagerPage/UserManager'
import Announcement from '../../components/ManagerPage/Announcement'
import SystemManage from '../../components/ManagerPage/SystemManage'

export default {
  components: {
    UserManager,
    Announcement,
    SystemManage
  },

  data: () => ({
    drawer: null
  }),

  methods: {
    TurnToUserManagerPage () {
      this.$router.push('/usermanager')
    },
    TurnToAnnouncementPage () {
      this.$router.push('/announcement')
    },
    TurnToSystemManagePage () {
      this.$router.push('/systemmanage')
    },
    Exit () {
      this.$store.commit('managerLogout')
      this.$router.push('/managerlogin')
    }
  },

  props: {
    source: String
  }
}
</script>

<style scoped>
hr {
  margin-top: 5px;
  margin-bottom: 8px;
}
</style>

