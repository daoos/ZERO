<template>
  <v-app id="inspire">
    <v-content>
      <v-container fluid fill-height>
        <v-layout align-center justify-center>
          <v-flex xs12 sm8 md6>
            <v-card>
              <v-toolbar dark color="red darken-2">
                <v-spacer></v-spacer>
                <router-link to="/login">
                  <v-tooltip bottom>
                    <v-icon slot="activator">close</v-icon>
                    <span>退出</span>
                  </v-tooltip>
                </router-link>
              </v-toolbar>
              <v-stepper v-model="e1">
                <v-stepper-header>
                  <v-stepper-step step="1" :complete="e1 > 1">输入邮箱</v-stepper-step>
                  <v-divider></v-divider>
                  <v-stepper-step step="2" :complete="e1 > 2">输入验证码</v-stepper-step>
                  <v-divider></v-divider>
                  <v-stepper-step step="3">密码重置</v-stepper-step>
                </v-stepper-header>
                <v-stepper-items>
                  <v-stepper-content step="1">
                    <EmailInput
                      @nextStep="e1 = 2"
                    ></EmailInput>
                  </v-stepper-content>
                  <v-stepper-content step="2">
                    <EnterIDCode
                      @previousStep="e1 = 1"
                      @nextStep="e1 = 3"
                    ></EnterIDCode>
                  </v-stepper-content>
                  <v-stepper-content step="3">
                    <PasswordReset
                      @previousStep="e1 = 1"
                      @nextStep="turnToLogin"
                    ></PasswordReset>
                  </v-stepper-content>
                </v-stepper-items>
              </v-stepper>
            </v-card>
          </v-flex>
        </v-layout>
      </v-container>
    </v-content>
  </v-app>
</template>

<script>
import EmailInput from "../../components/Reset/EmailInput"
import EnterIDCode from "../../components/Reset/EnterIDCode"
import PasswordReset from "../../components/Reset/PasswordReset"

export default {
  components: {
    EmailInput,
    EnterIDCode,
    PasswordReset
  },

  data: () => ({
    stepper: null,
    e1: 0
  }),

  methods: {
    turnToLogin () {
      this.$router.push('/login')
    }
  }
}
</script>

<style scoped>
a {
  text-decoration: none;
}
</style>
