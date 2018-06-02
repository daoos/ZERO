<template>
  <v-app id="inspire">
    <v-container fluid>
      <v-layout wrap class="gap">
        <v-flex sm12>
          <v-flex><h4>通知</h4></v-flex>
          <v-divider></v-divider>
        </v-flex>
        <v-flex sm12 class="section_first">
          <v-layout>
            <v-flex xs1>
              <span class="item">网页通知</span>
            </v-flex>
            <v-flex xs5>
              <v-select
                solo label="是的，我需要"
                v-model="select1"
                :items="WebNotification"
              >
              </v-select>
            </v-flex>
            <v-flex xs6></v-flex>
          </v-layout>
        </v-flex>
      </v-layout>
      <v-layout wrap class="gap">
        <v-flex sm12>
          <v-flex><h4>提醒</h4></v-flex>
          <v-divider></v-divider>
        </v-flex>
        <v-flex sm12 class="section_second">
          <v-layout>
            <v-flex xs1>
              <span class="item">规则</span>
            </v-flex>
            <v-flex xs5>
              <v-select
                solo label="当天"
                v-model="select2"
                :items="NotificationRules"
              >
              </v-select>
            </v-flex>
            <v-flex xs6></v-flex>
          </v-layout>
        </v-flex>
      </v-layout>
    </v-container>
  </v-app>
</template>

<script>
export default {
  data: () => ({
    select1: null,
    select2: null,
    WebNotification: [
      { text: '是的，我需要' },
      { text: '不用了，谢谢' }
    ],
    NotificationRules: [
      { text: '当天' },
      { text: '前一天' }
    ]
  })
}
</script>

<style scoped>
hr {
  margin-top: 10px;
}
.gap {
  margin-bottom: 30px;
}
.section_first {
  margin-top: 10px;
}
.section_second {
  margin-top: 20px;
}
.item {
  margin-left: 10px;
  color: #757575;
}
</style>
