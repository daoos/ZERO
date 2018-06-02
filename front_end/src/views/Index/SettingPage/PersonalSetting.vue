<template>
  <v-app id="inspire">
    <v-container fluid>
      <v-form>
        <v-layout wrap class="gap">
          <v-flex sm12>
            <v-flex><h4>个人信息</h4></v-flex>
            <v-divider></v-divider>
          </v-flex>
          <v-flex sm12 class="section_first">
            <v-layout>
              <v-flex xs1>
                <span class="item">头像</span>
              </v-flex>
              <v-flex xs5>
                <v-avatar
                  size="120" class="Avatar" id="avatar"
                  @click="showUploadDialog"
                >
                  <img :src="userAvatarPath" />
                </v-avatar>
                <!-- <input type="file" accept="image/*" id="uploadAvatar" style="display: none;" @change="modifyAvatar($event)" /> -->
              </v-flex>
              <v-flex xs6></v-flex>
            </v-layout>
          </v-flex>
          <v-dialog
            max-width="500px"
            v-model="avatarUploadDialog"
          >
            <v-card>
              <v-card-title>
                <h2 class="mx-auto">更改头像</h2>
              </v-card-title>
              <v-divider></v-divider>
              <v-card-text>
                <v-flex>
                  <v-text-field
                    solo label="请输入路径..."
                    v-model="thisUserAvatarPath"
                  ></v-text-field>
                </v-flex>
              </v-card-text>
              <v-divider></v-divider>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn
                  class="primary"
                  @click="saveAvatarPath"
                >
                  保存
                </v-btn>
                <v-btn @click="hideUploadDialog">取消</v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog>
          <v-flex sm12 class="section_first">
            <v-layout>
              <v-flex xs1>
                <span class="item">昵称</span>
              </v-flex>
              <v-flex xs1>
                <span class="Content" v-show="!Name">{{ this.userName }}</span>
                <v-text-field
                  solo dark name="name" class="elevation-5"
                  v-model="name"
                  v-show="Name"
                ></v-text-field>
              </v-flex>
              <v-flex xs10>
                <v-btn flat v-show="Button1" @click="update1">修改</v-btn>
                <v-btn dark color="grey darken-3" v-show="Button2" @click="submit1">保存</v-btn>
                <v-btn v-show="Button2" @click="clear1">取消</v-btn>
              </v-flex>
            </v-layout>
          </v-flex>
          <v-flex sm12 class="section_first">
            <v-layout>
              <v-flex xs1>
                <span class="item">邮箱地址</span>
              </v-flex>
              <v-flex xs2>
                <span class="Content">{{ this.userEmail }}</span>
                <!-- <v-dialog
                 max-width="650px"
                 v-model="Email"
                >
                  <v-card>
                    <v-card-title>修改邮箱地址</v-card-title>
                    <v-card-text>
                      <v-flex>
                        <v-text-field
                          solo class="Input elevation-5" label="请输入当前邮箱地址"
                          v-model="previousEmail"
                          :error-messages="previousEmailErrors"
                        ></v-text-field>
                      </v-flex>
                      <v-flex>
                        <v-text-field
                          solo class="elevation-5" label="请输入新的邮箱地址"
                          v-model="presentEmail"
                          :error-messages="presentEmailErrors"
                        ></v-text-field>
                      </v-flex>
                      <v-flex>
                        <span class="item">
                          *修改邮箱地址会修改登录账号
                        </span>
                      </v-flex>
                    </v-card-text>
                    <v-card-actions>
                      <v-spacer></v-spacer>
                      <v-btn dark color="grey darken-1" @click="clear2">取消</v-btn>
                      <v-btn dark color="red" @click="submit2">确认修改</v-btn>
                    </v-card-actions>
                  </v-card>
                </v-dialog> -->
              </v-flex>
              <!-- <v-flex xs7>
                <v-btn flat @click="update2">修改</v-btn>
              </v-flex> -->
            </v-layout>
          </v-flex>
          <v-flex sm12 class="section_first">
            <v-layout>
              <v-flex xs1>
                <span class="item">手机号码</span>
              </v-flex>
              <v-flex xs1>
                <span class="Content" v-show="!Phone">********{{ this.userPhone.substr(7,10) }}</span>
                <v-text-field
                  solo dark name="name" class="elevation-5"
                  v-model="phone"
                  v-show="Phone"
                  :error-messages="phoneErrors"
                ></v-text-field>
              </v-flex>
              <v-flex xs10>
                <v-btn flat v-show="Button3" @click="update3">修改</v-btn>
                <v-btn dark color="grey darken-3" v-show="Button4" @click="submit3">保存</v-btn>
                <v-btn v-show="Button4" @click="clear3">取消</v-btn>
              </v-flex>
            </v-layout>
          </v-flex>
          <v-flex sm12 class="section_first">
            <v-layout>
              <v-flex xs1>
                <span class="item">密码</span>
              </v-flex>
              <v-flex xs1>
                <span class="Content">********</span>
                <v-dialog
                 max-width="650px"
                 v-model="Password"
                >
                  <v-card>
                    <v-card-title>修改密码</v-card-title>
                    <v-card-text>
                      <v-flex>
                        <v-text-field
                          solo class="Password elevation-5" label="请输入当前密码"
                          v-model="previousPassword"
                          :error-messages="previousPasswordErrors"
                          :append-icon-cb="() => ( e2 = !e2 )"
                          :type="e2 ? 'password' : 'text'"
                          @input="$v.previousPassword.$touch()"
                          @blur="$v.previousPassword.$touch()"
                        ></v-text-field>
                      </v-flex>
                      <v-flex>
                        <v-text-field
                          solo name="password" class="Password elevation-5" label="请输入新的密码" onpaste="return false"
                          v-model="password"
                          :counter="30"
                          :error-messages="passwordErrors"
                          :append-icon="e2 ? 'visibility' : 'visibility_off'"
                          :append-icon-cb="() => ( e2 = !e2 )"
                          :type="e2 ? 'password' : 'text'"
                          @input="$v.password.$touch()"
                          @blur="$v.password.$touch()"
                        ></v-text-field>
                      </v-flex>
                      <v-flex>
                        <v-text-field
                          solo name="pswConfirm" class="Password elevation-5" label="请确认新的密码" onpaste="return false"
                          v-model="pswConfirm"
                          :counter="30"
                          :error-messages="pswConfirmErrors"
                          :append="e2 ? 'visibility' : 'visibility_off'"
                          :append-cb="() => ( e2 = !e2 )"
                          :type="e2 ? 'password' : 'text'"
                          @input="$v.pswConfirm.$touch()"
                          @blur="$v.pswConfirm.$touch()"
                        ></v-text-field>
                      </v-flex>
                    </v-card-text>
                    <v-card-actions>
                      <v-spacer></v-spacer>
                      <v-btn dark color="grey darken-1" @click="clear4">取消</v-btn>
                      <v-btn dark color="red" @click="submit4">确认修改</v-btn>
                    </v-card-actions>
                  </v-card>
                </v-dialog>
              </v-flex>
              <v-flex xs10>
                <v-btn flat @click="update4">修改</v-btn>
              </v-flex>
            </v-layout>
          </v-flex>
        </v-layout>
        <v-layout wrap class="gap">
          <v-flex sm12>
            <v-divider></v-divider>
          </v-flex>
          <v-flex sm12 class="section_second">
            <v-layout>
              <v-flex xs3>
                <span class="item">
                  <v-btn
                    outline block color="red"
                    @click.stop="DeleteAccount = true"
                  >
                    删除我的账号
                  </v-btn>
                  <v-flex>请输入您的当前密码</v-flex>
                </span>
                <v-dialog
                 max-width="650px"
                 v-model="DeleteAccount"
                >
                  <v-card>
                    <v-card-title>删除账号</v-card-title>
                    <v-card-text>
                      <v-select
                        solo label="请选择删除账号的原因，以便我们改进产品"
                        v-model="reason"
                        :items="Reason"
                      ></v-select>
                      <v-flex>
                        <span class="item">*删除账号操作不可逆转</span>
                      </v-flex>
                    </v-card-text>
                    <v-card-actions>
                      <v-spacer></v-spacer>
                      <v-btn dark color="red" @click="DeleteAccount = false">删除</v-btn>
                    </v-card-actions>
                  </v-card>
                </v-dialog>
              </v-flex>
              <v-flex xs9></v-flex>
            </v-layout>
          </v-flex>
        </v-layout>
      </v-form>
    </v-container>
  </v-app>
</template>

<script>
import { email, minLength, maxLength, sameAs , required} from 'vuelidate/lib/validators'

export default {
  validations: {
    previousEmail: { email },
    presentEmail: { email, sameAs: sameAs('previousEmail') },
    phone: { minLength: minLength(11), maxLength: maxLength(11) },
    previousPassword: { minLength: minLength(6), maxLength: maxLength(30) , required},
    password: { minLength: minLength(6), maxLength: maxLength(30) },
    pswConfirm: { minLength: minLength(6), maxLength: maxLength(30), sameAs: sameAs('password') }
  },

  data: () => ({
    userInfo: [],
    userAvatarPath: '',
    thisUserAvatarPath: '',
    userEmail: '',
    userName: '',
    userPhone: '',
    userPsw: '',
    avatarUploadDialog: false,
    Button1: true,
    Button2: false,
    Button3: true,
    Button4: false,
    name: '',
    Name: false,
    previousEmail: '',
    presentEmail: '',
    Email: false,
    phone: '',
    Phone: false,
    previousPassword: '',
    password: '',
    pswConfirm: '',
    Password: false,
    e2: true,
    reason: '',
    DeleteAccount: false,
    Reason: [
      { text: '无' },
      { text: '产品功能存在缺陷' },
      { text: '产品不符合我的原本预期' }
    ]
  }),

  mounted () {
    this.$nextTick(function () {
      this.findUserInfo()
    })
  },

  computed: {
    previousEmailErrors () {
      const errors = []
      if ( !this.$v.previousEmail.$dirty ) return errors
      !this.$v.previousEmail.email && errors.push('邮箱地址格式有误')
      return errors
    },
    presentEmailErrors () {
      const errors = []
      if ( !this.$v.presentEmail.$dirty ) return errors
      !this.$v.presentEmail.email && errors.push('邮箱地址格式有误')
      !this.$v.presentEmail.sameAs && errors.push('与原邮箱地址不可重复')
      return errors
    },
    phoneErrors () {
      const errors = []
      if ( !this.$v.phone.$dirty ) return errors
      !this.$v.phone.minLength && errors.push('电话号码不可少于11位')
      !this.$v.phone.maxLength && errors.push('电话号码不可少于11位')
      return errors
    },
    previousPasswordErrors () {
      const errors = []
      if ( !this.$v.previousPassword.$dirty ) return errors
      !this.$v.previousPassword.required && errors.push('密码不可为空')
      !this.$v.previousPassword.minLength && errors.push('密码不可少于6位')
      !this.$v.previousPassword.maxLength && errors.push('密码不可多于30位')
      return errors
    },
    passwordErrors () {
      const errors = []
      if ( !this.$v.password.$dirty ) return errors
      !this.$v.password.minLength && errors.push('密码不可少于6位')
      !this.$v.password.maxLength && errors.push('密码不可多于30位')
      this.$v.password.sameAs && errors.push('不可与原密码相同')
      return errors
    },
    pswConfirmErrors () {
      const errors = []
      if ( !this.$v.pswConfirm.$dirty ) return errors
      !this.$v.pswConfirm.minLength && errors.push('密码不可少于6位')
      !this.$v.pswConfirm.maxLength && errors.push('密码不可多于30位')
      !this.$v.pswConfirm.sameAs && errors.push('密码不一致')
      return errors
    }
  },

  methods: {
    findUserInfo () {
      var that = this

      this.axios({
        headers: { 'token': localStorage.token },
        method: 'GET',
        url: '/user/finduserinfo',
        data: {},
        dataType: 'json'
      })
      .then(function (response) {
        that.userInfo = response.data

        that.userAvatarPath = response.data.userAvatarPath
        that.userEmail = response.data.userEmail
        that.userName = response.data.userName
        that.userPhone = response.data.userPhone
        that.userPsw = response.data.userPsw
      })
      .catch(function (error) {
        console.log(error)
      })
    },
    showUploadDialog () {
      this.avatarUploadDialog = true
    },
    saveAvatarPath () {
      var that = this

      this.axios({
        headers: { 'token': localStorage.token },
        method: 'PATCH',
        url: '/user/modify',
        data: {
          "userAvatarPath": this.thisUserAvatarPath
        },
        dataType: 'json'
      })
      .then(function (response) {
        that.findUserInfo()

        that.avatarUploadDialog = false
      })
      .catch(function (error) {
        console.log(error)
      })
    },
    hideUploadDialog () {
      this.thisUserAvatarPath = ''
      this.avatarUploadDialog = false
    },
    // showUploadDialog (e) {
    //   document.getElementById('uploadAvatar').click()
    // },
    // modifyAvatar (e) {
    //   var that = this

    //   let file = e.target.files[0]
    //   console.log(file)
    //   // let reader = new FileReader()
    //   // let img = new Image()
    //   // reader.readAsDataURL(file)

    //   // let avatar = document.getElementById('avatar')
    //   // let context = avatar.getContext('2d')
    //   // reader.onload = function (e) {
    //   //   img.src = e.target.result
    //   // }
    // },
    update1 () {
      this.Name = !this.Name
      this.Button1 = !this.Button1
      this.Button2 = !this.Button2
    },
    submit1 () {
      this.$v.$touch()
    },
    clear1 () {
      this.name = ''
      this.Name = !this.Name
      this.Button1 = !this.Button1
      this.Button2 = !this.Button2
    },
    update2 () {
      this.Email = !this.Email
    },
    submit2 () {
      this.$v.$touch()
    },
    clear2 () {
      this.previousEmail = ''
      this.presentEmail = ''
      this.Email = !this.Email
    },
    update3 () {
      this.Phone = !this.Phone
      this.Button3 = !this.Button3
      this.Button4 = !this.Button4
    },
    submit3 () {
      this.$v.$touch()
    },
    clear3 () {
      this.phone = ''
      this.Phone = !this.Phone
      this.Button3 = !this.Button3
       this.Button4 = !this.Button4
    },
    update4 () {
      this.Password = !this.Password
    },
    submit4 () {
      this.$v.$touch()
    },
    clear4 () {
      this.previousPassword = ''
      this.password = ''
      this.pswConfirm = ''
      this.Password = !this.Password
    }
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
.section_first {
  margin-top: 20px;
}
.section_second {
  margin-top: 20px;
}
.item {
  margin-left: 10px;
  color: #757575;
}
.Avatar:hover {
  cursor: pointer;
  opacity: 0.6;
}
.Content {
  margin-left: 20px;
  font-size: 18px;
}
.Input {
  margin-bottom: 15px;
}
.Password {
  margin-bottom: 40px;
}
</style>
