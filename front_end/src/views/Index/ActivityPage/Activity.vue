<template>
  <v-app id="inspire">
    <v-navigation-drawer
      app fixed
      v-model="drawer"
      :clipped="$vuetify.breakpoint.lgAndUp"
    >
      <v-list dense>
        <template v-for="item in items">
          <v-list-tile :key="item.id" @click="item(item.id)" >
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
      app dark fixed color="red accent-2"
      :clipped-left="$vuetify.breakpoint.lgAndUp"
    >
      <v-toolbar-title class="ml-0 pl-3" style="width: 300px">
        <v-toolbar-side-icon @click.stop="drawer = !drawer"></v-toolbar-side-icon>
        <span class="hidden-sm-and-down">活动日志</span>
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
      <v-container fluid fill-height>
        <v-layout justify-center align-center>
        </v-layout>
      </v-container>
    </v-content>
  </v-app>
</template>

<script>
  export default {
    data: () => ({
      drawer: null,
      items: [
        { id: 0, icon: 'person', text: '账户' }
      ]
    }),

    methods: {
      item (id) {
        switch (id)
        {
          case 0:
            break;
          case 1:
            break;
          default:
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
