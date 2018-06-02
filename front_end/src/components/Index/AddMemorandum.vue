<template>
  <v-form>
    <v-card>
      <v-card-title>
        <span class="headline">添加备忘录</span>
      </v-card-title>
      <v-card-text>
        <v-container grid-list-md>
          <v-layout wrap>
            <v-flex sm12 md12>
              <v-text-field
                solo class="elevation-5"
                v-model="text"
                :error-messages="textErrors"
                @input="$v.text.$touch()"
              ></v-text-field>
            </v-flex>
            <v-flex
              class="Textarea"
              ref="editor"
            ></v-flex>
          </v-layout>
        </v-container>
      </v-card-text>
      <v-card-actions>
        <v-btn dark color="grey darken-4">保存</v-btn>
        <v-btn @click.native="hideDialog">取消</v-btn>
      </v-card-actions>
    </v-card>
  </v-form>
</template>

<script>
import { minLength, maxLength } from 'vuelidate/lib/validators'
import E from 'wangeditor'

export default {
  validations: {
    text: { minLength: minLength(1), maxLength: maxLength(15) },
  },

  name: 'editor',

  data: () => ({
    text: '',
    editorContent: '',
  }),

  mounted () {
    var editor = new E(this.$refs.editor)
      // 忽略粘贴内容中的图片
      editor.customConfig.pasteIgnoreImg = true
      // 自定义菜单项
      editor.customConfig.menus = [
        'fontName',
        'fontSize',
        'fontColor',
        'justify',
        'bold',
        'underline',
        'list',
        'image',
        'undo'
      ]
      // 插入网络图片回调
      editor.customConfig.linkImgCallback = function (url) {
        console.log(url) // url 即插入图片的地址
      }
      // 插入网络图片校验
      editor.customConfig.linkImgCheck = function (src) {
        console.log(src)
        // 返回'true'则表示校验成功
        // 返回'校验失败'则表示校验失败
        return true
      }
      // editor.customConfig.onchange = (html) => {
      //   this.editorContent = html
      // }
      editor.create()
  },

  computed: {
    textErrors () {
      const errors = []
      if ( !this.$v.text.$dirty ) return errors
      !this.$v.text.minLength && errors.push('标题不可为空')
      !this.$v.text.maxLength && errors.push('标题字数不可多于15')
      return errors
    },
  },

  methods: {
    hideDialog () {
      this.text = ''
      this.$emit('hideDialog')
    },
  }
}
</script>

<style scoped>
.Textarea {
  max-width: 760px;
}
</style>
