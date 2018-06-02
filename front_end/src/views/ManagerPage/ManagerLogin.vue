<template>
  <v-app id="inspire">
    <v-content>
      <v-container fluid fill-height>
        <v-layout align-center justify-center>
          <v-flex xs12 sm8 md4>
            <v-form v-model="valid" ref="form">
              <v-card class="elevation-12">
                <v-toolbar dark color="light-green darken-1">
                  <router-link to="/welcome">
                    <v-tooltip bottom>
                      <v-icon slot="activator">close</v-icon>
                      <span>退出</span>
                    </v-tooltip>
                  </router-link>
                  <v-spacer></v-spacer>
                </v-toolbar>
                <v-card-text>
                  <v-alert
                    dismissible transition="scale-transition" type="error"
                    v-model="alert"
                  >
                    账号或密码错误，请重新输入
                  </v-alert>
                  <v-text-field
                    clearable prepend-icon="person" name="username" label="账号" type="text" color="light-green darken-1"
                    v-model="username"
                    :error-messages="usernameErrors"
                    @input="$v.username.$touch()"
                    @blur="$v.username.$touch()"
                  ></v-text-field>
                  <v-text-field
                    prepend-icon="lock" name="password" id="password" label="密码" onpaste="return false" color="light-green darken-1"
                    v-model="password"
                    :error-messages="passwordErrors"
                    :type="visibility ? 'password' : 'text'"
                    @input="$v.password.$touch()"
                    @blur="$v.password.$touch()"
                  ></v-text-field>
                </v-card-text>
                <v-card-actions>
                  <v-spacer></v-spacer>
                  <v-btn
                    dark color="light-green darken-1"
                    @click="login"
                  >
                    登入
                  </v-btn>
                </v-card-actions>
              </v-card>
            </v-form>
          </v-flex>
        </v-layout>
      </v-container>
    </v-content>
  </v-app>
</template>

<script>
import { required } from 'vuelidate/lib/validators'

export default {
  validations: {
    username: { required },
    password: { required }
  },

  data: () => ({
    valid: true,
    alert: false,
    username: '',
    password: '',
    visibility: true,
  }),

  computed: {
    usernameErrors () {
      const errors = []
      if ( !this.$v.username.$dirty ) return errors
      !this.$v.username.required && errors.push('账号不可为空')
      return errors
    },
    passwordErrors () {
      const errors = []
      if ( !this.$v.password.$dirty ) return errors
      !this.$v.password.required && errors.push('密码不可为空')
      return errors
    }
  },

  methods: {
    login () {
      var that = this

      this.$v.$touch()
      if ( !this.$v.$invalid ) {
        this.axios({
          method: 'POST',
          url: '/manager/login',
          data: {
            "managerId": that.username,
            "managerPsw": that.password
          },
          dataType: 'json'
        })
        .then(function (response) {
          that.$store.commit('managerLogin', response.data.data)
          that.$router.push({ path: '/ManagerPage' })
        })
        .catch(function (error) {
          console.log(error)
        })
      }
    }
  }
}
</script>

<style scoped>
a {
  text-decoration: none;
}
.Link {
  position: absolute;
  right: 10px;
  font-size: 15px;
}
</style>
