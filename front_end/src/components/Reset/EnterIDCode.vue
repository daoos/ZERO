<template>
  <v-form>
    <v-card class="elevation-12">
      <v-card-text>
        <v-alert
          dismissible transition="scale-transition" type="error"
          v-model="alert"
        >
          验证码错误，请重新输入
        </v-alert>
        <v-layout nowrap id="Box">
            <v-text-field
            solo placeholder=" 0  0  0  0" class="elevation-12 mx-auto Mask"
            v-model="code"
            :mask="mask"
            :error-messages="codeErrors"
            @input="$v.code.$touch()"
            @blur="$v.code.$touch()"
          ></v-text-field>
        </v-layout>
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
import { minLength } from 'vuelidate/lib/validators'

export default {
  validations: {
    code: { minLength: minLength(4) }
  },

  data: () => ({
    alert: false,
    error: false,
    code: '',
    mask: ' #  #  #  #'
  }),

  computed: {
    codeErrors () {
      const errors = []
      if ( !this.$v.code.$dirty ) return errors
      !this.$v.code.minLength && errors.push('验证码不可少于4位')
      return errors
    },
  },

  methods: {
    previousStep () {
      this.$emit('previousStep')
    },
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
.Mask {
  max-width: 100px;
}
</style>
