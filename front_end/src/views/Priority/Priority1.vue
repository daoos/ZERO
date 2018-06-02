<template>
  <v-app id="inspire">
    <v-container fluid>
      <v-layout class="gap">
        <v-flex>
          <h2>优先级1</h2>
        </v-flex>
      </v-layout>
      <v-layout
        class="gap"
        v-show="Expired"
      >
        <v-flex>
          <h4 class="Expired">已过期</h4>
          <v-divider></v-divider>
        </v-flex>
      </v-layout>
      <v-layout
        class="gap"
        v-show="Expired"
      >
        <v-flex>
          <h4>进行中</h4>
          <v-divider></v-divider>
        </v-flex>
      </v-layout>
    </v-container>
  </v-app>
</template>

<script>
export default {
  data: () => ({
    Expired: true,
    todo2: true,
    todo3: true,
    todo4: true,
    todo5: true,
    checkboxShow2: true,
    checkboxShow3: true,
    checkboxShow4: true,
    checkboxShow5: true,
  }),

  computed: {
  },

  methods: {
    hideTodo2() {
      this.todo2 = false
    },
    hide2() {
      this.todo2 = !this.todo2
    },
    hideTodo3() {
      this.todo3 = false
    },
    hide3() {
      this.todo3 = !this.todo3
    },
    hideTodo4() {
      this.todo4 = false
    },
    hide4() {
      this.todo4 = !this.todo4
    },
    hideTodo5() {
      this.todo5 = false
    },
    hide5() {
      this.todo5 = !this.todo5
    },
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
.CheckBox {
  margin-top: 25px;
  margin-left: 20px;
  max-width: 50px;;
}
.Inventory {
  position: absolute;
  right: 100px;
}
.Setting {
  opacity: 0;
}
.Setting:hover {
  opacity: 1;
}
</style>
