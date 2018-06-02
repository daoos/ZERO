<template>
  <v-app id="inspire">
    <v-navigation-drawer
      app dark fixed
      v-model="drawer"
      :clipped="$vuetify.breakpoint.lgAndUp"
    >
      <v-list dense>
        <template v-for="item in items">
          <v-list-tile :key="item.id" @click="Items(item.id)" >
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
      app fixed color="grey lighten-3"
      :clipped-left="$vuetify.breakpoint.lgAndUp"
    >
      <v-toolbar-title class="ml-0 pl-3" style="width: 300px">
        <v-toolbar-side-icon @click.stop="drawer = !drawer"></v-toolbar-side-icon>
        <span class="hidden-sm-and-down">设置</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <span>关闭</span>
      <router-link to="/index">
        <v-btn icon >
          <v-icon medium>close</v-icon>
        </v-btn>
      </router-link>
    </v-toolbar>
    <v-content>
      <router-view />
    </v-content>
  </v-app>
</template>

<script>
  export default {
    data: () => ({
      drawer: null,
      items: [
        { id: 0, icon: 'person', text: '个人设置' },
        { id: 1, icon: 'settings_applications', text: '常规设置' },
        { id: 2, icon: 'notifications_none', text: '提醒规则' },
      ]
    }),

    methods: {
      Items (id) {
        switch (id)
        {
          case 0:
            this.$router.push('/personalSetting')
            break;
          case 1:
            this.$router.push('/generalSetting')
            break;
          default:
            this.$router.push('/reminderRules')
            break;
        }
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
</style>
