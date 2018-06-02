<template>
  <v-form>
    <v-card class="elevation-12">
      <v-card-text>
        <v-alert
          dismissible transition="scale-transition" type="error"
          v-model="alert"
        >
          此邮箱不存在，请重新输入
        </v-alert>
        <v-text-field
          clearable prepend-icon="email" color="teal lighten-1" name="email" label="邮箱地址" type="text"
          v-model="email"
          :error-messages="emailErrors"
          @input="$v.email.$touch()"
          @blur="$v.email.$touch()"
          required
        ></v-text-field>
      </v-card-text>
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn
          dark color="red darken-2"
          @click.native="nextStep"
        >
          发送验证码
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-form>
</template>

<script>
import { email, required } from 'vuelidate/lib/validators'

export default {
  validations: {
    email: { email, required },
  },

  data: () => ({
    alert: false,
    email: ''
  }),

  computed: {
    emailErrors () {
      const errors = []
      if ( !this.$v.email.$dirty ) return errors
      !this.$v.email.email && errors.push('邮箱地址格式有误')
      !this.$v.email.required && errors.push('邮箱地址不可为空')
      return errors
    },
  },

  methods: {
    nextStep () {
      this.$v.$touch()
      if ( !this.$v.$invalid ) {
        this.$emit('nextStep')
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
