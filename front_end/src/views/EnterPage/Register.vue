<template>
  <v-app id="inspire">
    <v-content>
      <v-container fluid fill-height>
        <v-layout align-center justify-center>
          <v-flex xs12 sm8 md4>
            <v-form>
              <v-card class="elevation-12">
                <v-toolbar dark color="teal darken-1">
                  <router-link to="/login">
                    <v-tooltip bottom>
                      <v-icon slot="activator">arrow_back</v-icon>
                      <span>返回登录界面</span>
                    </v-tooltip>
                  </router-link>
                  <v-spacer></v-spacer>
                  <router-link to="/welcome">
                    <v-tooltip bottom>
                      <v-icon slot="activator">close</v-icon>
                      <span>退出</span>
                    </v-tooltip>
                  </router-link>
                </v-toolbar>
                <v-card-text>
                  <v-alert
                    dismissible transition="scale-transition" type="error"
                    v-model="alert"
                  >
                    <span v-text="alertContent"></span>
                  </v-alert>
                  <v-text-field
                    clearable color="teal darken-1" name="email" label="邮箱地址" type="text"
                    v-model="email"
                    :error-messages="emailErrors"
                    @input="$v.email.$touch()"
                    @blur="emailCheck"
                    required
                  ></v-text-field>
                  <v-text-field
                    color="teal darken-1" onpaste="return false;" name="password" id="password" label="密码"
                    v-model="password"
                    :counter="30"
                    :error-messages="passwordErrors"
                    :append-icon="e2 ? 'visibility' : 'visibility_off'"
                    :append-icon-cb="() => ( e2 = !e2 )"
                    :type="e2 ? 'password' : 'text'"
                    @input="$v.password.$touch()"
                    @blur="$v.password.$touch()"
                    required
                  ></v-text-field>
                  <v-text-field
                    color="teal darken-1" onpaste="return false" name="pswConfirm" id="pswConfirm" label="确认密码"
                    v-model="pswConfirm"
                    :counter="30"
                    :error-messages="pswConfirmErrors"
                    :append="e2 ? 'visibility' : 'visibility_off'"
                    :append-cb="() => ( e2 = !e2 )"
                    :type="e2 ? 'password' : 'text'"
                    @input="$v.pswConfirm.$touch()"
                    @blur="$v.pswConfirm.$touch()"
                    required
                  ></v-text-field>
                  <v-text-field
                    clearable color="teal darken-1" name="username" id="username" label="用户昵称"
                    v-model="username"
                    :error-messages="usernameErrors"
                    @input="$v.username.$touch()"
                    @blur="usernameCheck"
                    required
                  ></v-text-field>
                  <v-text-field
                    clearable color="teal darken-1" name="phone" id="phone" label="手机号码"
                    v-model="phone"
                  ></v-text-field>
                </v-card-text>
                <v-card-actions>
                  <v-spacer></v-spacer>
                  <v-btn
                    dark color="teal darken-1"
                    @click="regist()"
                  >
                    确认注册
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
import { email, minLength, maxLength, sameAs, required } from 'vuelidate/lib/validators'

export default {
  validations: {
    email: { email, required },
    password: { minLength: minLength(6), maxLength: maxLength(30), required },
    pswConfirm: { minLength: minLength(6), maxLength: maxLength(30), sameAs: sameAs('password'), required },
    username: { required }
  },

  data: () => ({
    alert: false,
    alertContent: '',
    email: '',
    password: '',
    pswConfirm: '',
    username: '',
    phone: '',
    e2: true,
  }),

  computed: {
    emailErrors () {
      const errors = []
      if ( !this.$v.email.$dirty ) return errors
      !this.$v.email.email && errors.push('邮箱地址格式有误')
      !this.$v.email.required && errors.push('邮箱地址不可为空')
      this.email == '471602137@qq.com' && errors.push('此邮箱已被占用')
      return errors
    },
    passwordErrors () {
      const errors = []
      if ( !this.$v.password.$dirty ) return errors
      !this.$v.password.required && errors.push('密码不可为空')
      !this.$v.password.minLength && errors.push('密码不可少于6位')
      !this.$v.password.maxLength && errors.push('密码不可多于30位')
      return errors
    },
    pswConfirmErrors () {
      const errors = []
      if ( !this.$v.pswConfirm.$dirty ) return errors
      !this.$v.pswConfirm.required && errors.push('密码不可为空')
      !this.$v.pswConfirm.minLength && errors.push('密码不可少于6位')
      !this.$v.pswConfirm.maxLength && errors.push('密码不可多于30位')
      !this.$v.pswConfirm.sameAs && errors.push('密码不一致')
      return errors
    },
    usernameErrors () {
      const errors = []
      if ( !this.$v.username.$dirty ) return errors
      !this.$v.username.required && errors.push('用户昵称不可为空')
      return errors
    },
    Today () {
      var date = new Date()
      var Today = date.toISOString().substr(0, 10)
      return Today
    }
  },

  methods: {
    emailCheck () {
      var that = this

      this.axios({
        method: 'GET',
        url: '/user/' + this.email + '/find',
        data: {},
        dataType: 'json'
      })
      .then(function (response) {
        if ( response.data.userEmail != null ) {
          that.alertContent = '此邮箱地址已被占用,请重新输入!'
          that.alert = true
        }
      })
      .catch(function (error) {
        console.log(error)
      })
    },
    usernameCheck () {
      var that = this

      this.axios({
        method: 'GET',
        url: '/user/' + this.username + '/findusername',
        data: {},
        dataType: 'json'
      })
      .then(function (response) {
        if ( response.data.userName != null ) {
          that.alertContent = '该用户名已被占用，请重新输入！'
          that.alert = true
        }
      })
      .catch(function (error) {
        console.log(error)
      })
    },
    regist () {
      var that = this

      this.$v.$touch()
      if ( !this.$v.$invalid ) {
        this.axios({
          method: 'POST',
          url: '/user/register',
          data: {
            "userCreateTime": this.Today,
            "userEmail": this.email,
            "userPsw": this.password,
            "userPhone": this.userPhone,
            "userName": this.username
          },
          dataType: 'json'
        })
        .then(function (response) {
          that.$router.push('/login')
        })
        .catch(function (error) {
          console.log(error)
        })
      }
    },
  }
}
</script>

<style scoped>
a {
  text-decoration: none;
}
hr {
  margin-top: 5px;
  margin-bottom: 5px;
}
.Check {
  margin-top: 22px;
  max-width: 5px;
}
</style>
