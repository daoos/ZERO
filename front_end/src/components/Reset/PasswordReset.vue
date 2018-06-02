<template>
  <v-form>
    <v-card class="elevation-12">
      <v-card-text>
        <v-alert
          dismissible transition="scale-transition" type="error"
          v-model="alert"
        >
          新密码不可与原密码相同
        </v-alert>
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
            required
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
            required
          ></v-text-field>
        </v-flex>
      </v-card-text>
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn
          dark color="grey darken-1"
          @click.native="previousStep"
        >
          返回
        </v-btn>
        <v-btn
          dark color="red darken-2"
          @click.native="nextStep"
        >
          确定
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-form>
</template>

<script>
import { minLength, maxLength, sameAs, required } from 'vuelidate/lib/validators'

export default {
  validations: {
    password: { minLength: minLength(6), maxLength: maxLength(30), required  },
    pswConfirm: { minLength: minLength(6), maxLength: maxLength(30), sameAs: sameAs('password'), required }
  },

  data: () => ({
    alert: false,
    password: '',
    pswConfirm: '',
    e2: true
  }),

  computed: {
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
    }
  },

  methods: {
    previousStep () {
      this.$emit('previousStep')
    },
    nextStep () {
      this.$v.$touch()
      if ( !this.$v.$invalid ) {
        var that = this

        this.axios({
          method: 'PATCH',
          url: '/user/resetpsw',
          data: {
            // "userEmail": this.username,
            "userPsw": this.password
          },
          dataType: 'json'
        })
        .then(function (response) {
          that.$emit('nextStep')
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
.Password {
  margin-bottom: 15px;
}
</style>
