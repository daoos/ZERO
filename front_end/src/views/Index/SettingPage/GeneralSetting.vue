<template>
  <v-app id="inspire">
    <v-container fluid>
      <v-layout wrap class="gap">
        <v-flex sm12>
          <v-flex><h4>常规</h4></v-flex>
          <v-divider></v-divider>
        </v-flex>
        <v-flex sm12 class="section_first">
          <v-layout>
            <v-flex xs1>
              <span class="item">语言</span>
            </v-flex>
            <v-flex xs5>
              <v-select
                solo label="中文"
                v-model="select1"
                :items="Language"
              >
              </v-select>
            </v-flex>
            <v-flex xs6></v-flex>
          </v-layout>
        </v-flex>
        <v-flex sm12 class="section_second">
          <v-layout>
            <v-flex xs1>
              <span class="item">起始页</span>
            </v-flex>
            <v-flex xs5>
              <v-select
                solo label="无"
                v-model="select2"
                :items="StratingPage"
              >
              </v-select>
            </v-flex>
            <v-flex xs6></v-flex>
          </v-layout>
        </v-flex>
        <v-flex sm12 class="section_second">
          <v-layout>
            <v-flex xs1>
              <span class="item">智能日期识别</span>
            </v-flex>
            <v-flex xs5>
              <v-select
                solo label="是的，我需要"
                v-model="select3"
                :items="DateRecognise"
              >
              </v-select>
            </v-flex>
            <v-flex xs6></v-flex>
          </v-layout>
        </v-flex>
        <v-flex sm12 class="section_second">
          <v-layout>
            <v-flex xs1>
              <span class="item">自动接收邀请</span>
            </v-flex>
            <v-flex xs5>
              <v-select
                solo label="不用了，谢谢"
                v-model="select4"
                :items="Invite"
              >
              </v-select>
            </v-flex>
            <v-flex xs6></v-flex>
          </v-layout>
        </v-flex>
      </v-layout>
      <v-layout wrap class="gap">
        <v-flex sm12>
          <v-flex><h4>日期和时间</h4></v-flex>
          <v-divider></v-divider>
        </v-flex>
        <v-flex sm12 class="section_second">
          <v-layout>
            <v-flex xs1>
              <span class="item">时间格式</span>
            </v-flex>
            <v-flex xs5>
              <v-select
                solo label="24小时制"
                v-model="select5"
                :items="TimeFormat"
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
    select3: null,
    select4: null,
    select5: null,
    Language: [
      { text: '中文' },
      { text: 'English' }
    ],
    StratingPage: [
      { text: '无' },
      { text: '今天' },
      { text: '备忘录' },
      { text: '未来7天' }
    ],
    DateRecognise: [
      { text: '是的，我需要' },
      { text: '不用了，谢谢' }
    ],
    Invite: [
      { text: '是的，我需要' },
      { text: '不用了，谢谢' }
    ],
    TimeFormat: [
      { text: '24小时制' },
      { text: '12小时制' }
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
