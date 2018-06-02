<template>
  <v-app light id="app">
    <v-content>
      <v-toolbar class="white">
        <v-flex xs1 sm1 lg1 md1 xl1></v-flex>
        <v-flex xs3 sm4 lg6 md6 xl7>
          <img src="../../assets/pictures/Welcome/Logo/Zero Logo(blue).png" alt="#" height="50" />
        </v-flex>
        <v-flex xs8 sm7 lg5 md5 xl4 id="EnterButton">
          <router-link to="/login"><v-btn flat class="EnterButton">登录</v-btn></router-link>
          <router-link to="/register"><v-btn flat class="EnterButton">注册</v-btn></router-link>
        </v-flex>
      </v-toolbar>
      <section>
        <v-parallax :src="require('../../assets/pictures/Welcome/Background/First.jpeg')" height="600">
          <v-layout column align-center justify-center class="white--text">
            <h2 class="white--text mb-2 display-2 text-xs-center">To-Do List 任务事项列表及管理</h2>
            <h2 class="white--text mb-2 display-1 text-xs-center">使用Zero，不再错过任何信息</h2>
          </v-layout>
        </v-parallax>
      </section>
      <section>
        <v-layout column wrap align-center class="my-5">
          <v-flex xs12 sm4 class="my-3">
            <div class="text-xs-center">
              <h2 class="headline">学习如何规划生活</h2>
              <span class="subheading">然后享受生活</span>
            </div>
          </v-flex>
          <v-flex xs12>
            <v-container grid-list-xl>
              <v-layout row wrap align-center>
                <v-flex xs4 md4>
                  <v-card class="elevation-0 transparent">
                    <v-card-text class="text-xs-center">
                      <v-icon x-large class="blue--text text--dark-2">add_circle_outline</v-icon>
                    </v-card-text>
                    <v-card-title primary-title class="layout justify-center">
                      <div class="headline text-xs-center">记录和管理任务事项</div>
                    </v-card-title>
                    <v-card-text>
                      当某些想法浮现在您的脑海当中时，马上使用快速添加，避免错过任何一个绝妙的念头。
                    </v-card-text>
                  </v-card>
                </v-flex>
                <v-flex xs4 md4>
                  <v-card class="elevation-0 transparent">
                    <v-card-text class="text-xs-center">
                      <v-icon x-large class="blue--text text--dark-2">autorenew</v-icon>
                    </v-card-text>
                    <v-card-title primary-title class="layout justify-center">
                      <div class="headline">周而复始并养成习惯</div>
                    </v-card-title>
                    <v-card-text>
                      使用截止日期或循环截止日期，例如“每个周一”。
                    </v-card-text>
                  </v-card>
                </v-flex>
                <v-flex xs4 md4>
                  <v-card class="elevation-0 transparent">
                    <v-card-text class="text-xs-center">
                      <v-icon x-large class="blue--text text--dark-2">today</v-icon>
                    </v-card-text>
                    <v-card-title primary-title class="layout justify-center">
                      <div class="headline text-xs-center">事先预览一天或一周内的任务</div>
                    </v-card-title>
                    <v-card-text>
                      当您准备开始一天的工作，请先预览待办事项，完成时记得划掉它们。
                    </v-card-text>
                  </v-card>
                </v-flex>
              </v-layout>
            </v-container>
          </v-flex>
        </v-layout>
      </section>
      <section>
        <v-parallax :src="require('../../assets/pictures/Welcome/Background/Second.jpg')" height="380">
          <v-layout column align-center justify-center>
            <div class="headline white--text mb-3 text-xs-center">使用Zero整理您的思路</div>
            <router-link to="/register"><v-btn dark large class="blue dark-2 mt-5">立即加入 -- 完全免费</v-btn></router-link>
          </v-layout>
        </v-parallax>
      </section>
      <section>
        <v-container grid-list-xl>
          <v-layout row wrap justify-center class="my-5">
            <v-flex xs12 sm12 md12>
              <v-card class="elevation-0 transparent">
                <v-card-title primary-title class="layout justify-center">
                  <div class="headline">适用于主流的浏览器*</div>
                </v-card-title>
                <v-card-text>
                  <div class="layout justify-center">*仅支持IE9及以上的版本</div>
                  <v-layout>
                    <v-flex
                      xs12 sm12
                      v-for="(col, i) in items"
                      :key="i"
                    >
                      <v-card class="elevation-0 transparent">
                        <v-card-title primary-title class="layout justify-center">
                          <img :src="col.icon" height="100px" />
                        </v-card-title>
                        <v-card-text class="text-xs-center">
                          <h4
                            v-for="(words, i) in col.text"
                            :key="i"
                            v-text="words"
                          ></h4>
                        </v-card-text>
                      </v-card>
                    </v-flex>
                  </v-layout>
                </v-card-text>
              </v-card>
            </v-flex>
          </v-layout>
        </v-container>
      </section>
      <Footer></Footer>
    </v-content>
  </v-app>
</template>

<script>
import Footer from '../../components/Footer'

export default {
  name: 'Welcome',
  components: {
    Footer
  },
  data: () => ({
    items: [
      {
        icon: require('../../assets/pictures/Welcome/Broswer Icons/Chrome.png'),
        text: ['Google Chrome']
      },
      {
        icon: require('../../assets/pictures/Welcome/Broswer Icons/Firefox.png'),
        text: ['Molliza Firefox']
      },
      {
        icon: require('../../assets/pictures/Welcome/Broswer Icons/Opera.png'),
        text: ['Opera']
      },
      {
        icon: require('../../assets/pictures/Welcome/Broswer Icons/Edge.png'),
        text: ['Microsoft Edge']
      },
    ]
  })
}
</script>

<style scoped>
a {
  text-decoration: none;
}
#EnterButton {
  position: absolute;
  right: 0;
}
.EnterButton {
  height: 64px;
}
.EnterButton:hover {
  border-bottom: 4px solid #1976D2;
}
</style>
