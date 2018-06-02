<template>
  <v-app id="inspire">
    <v-container fluid>
      <v-layout class="gap">
        <v-flex>
          <h2>备忘录</h2>
        </v-flex>
      </v-layout>
      <v-layout nowrap class="gap">
        <v-flex>
          <v-divider></v-divider>
        </v-flex>
      </v-layout>
      <v-layout>
        <v-flex>
          <v-expansion-panel>
            <v-expansion-panel-content expand-icon="mdi-menu-down" v-show="Memorandum1">
              <div slot="header">今天要开始学习《投资学》
                <v-icon
                  class="Setting"
                  @click="showDialog1"
                >
                  more_horiz
                </v-icon>
                <v-icon
                class="Delete"
                @click="delete1"
              >
                delete_forever
              </v-icon>
              </div>
              <v-card>
                <v-card-text class="grey lighten-3">
                  <span>1.制定学习的计划</span><br />
                  <span>2.按照学习的计划进行预习</span><br />
                  <span>3.预期10天之内完成</span>
                </v-card-text>
              </v-card>
            </v-expansion-panel-content>
            <v-dialog
              persistent max-width="800px"
              v-model="dialog1"
            >
              <v-card>
                <v-card-text>
                  <v-container grid-list-md>
                    <v-layout wrap>
                      <v-flex sm12 md12>
                        <v-text-field
                          solo class="elevation-5" v-model="Title1"
                        ></v-text-field>
                      </v-flex>
                      <v-flex
                        class="Textarea"
                        ref="editor1"
                      ></v-flex>
                    </v-layout>
                  </v-container>
                </v-card-text>
                <v-card-actions>
                  <v-spacer></v-spacer>
                  <v-btn
                    dark color="grey darken-4"
                    @click="Save"
                  >
                    保存
                  </v-btn>
                  <v-btn @click="hideDialog1">取消</v-btn>
                </v-card-actions>
              </v-card>
            </v-dialog>
            <v-expansion-panel-content expand-icon="mdi-menu-down" v-show="Memorandum2">
              <div slot="header">这张图片不错
                <v-icon
                  class="Setting"
                  @click="showDialog2"
                >
                  more_horiz
                </v-icon>
                <v-icon
                class="Delete"
                @click="delete2"
              >
                delete_forever
              </v-icon>
              </div>
              <v-card>
                <v-card-text class="grey lighten-3">
                  <img src="../../assets/pictures/Avatar/Marvel.jpg" alt="#" />
                </v-card-text>
              </v-card>
            </v-expansion-panel-content>
            <v-dialog
              persistent max-width="800px"
              v-model="dialog2"
            >
              <v-card>
                <v-card-text>
                  <v-container grid-list-md>
                    <v-layout wrap>
                      <v-flex sm12 md12>
                        <v-text-field
                          solo class="elevation-5"
                          v-model="Title2"
                        ></v-text-field>
                      </v-flex>
                      <v-flex
                        class="Textarea"
                        ref="editor2"
                      ></v-flex>
                    </v-layout>
                  </v-container>
                </v-card-text>
                <v-card-actions>
                  <v-spacer></v-spacer>
                  <v-btn
                    dark color="grey darken-4"
                    @click="Save"
                  >
                    保存
                  </v-btn>
                  <v-btn @click="hideDialog2">取消</v-btn>
                </v-card-actions>
              </v-card>
            </v-dialog>
            <v-expansion-panel-content
              expand-icon="mdi-menu-down"
              v-show="Memorandum3"
            >
              <div slot="header">介绍我的偶像
                <v-icon
                  class="Setting"
                  @click="showDialog3"
                >
                  more_horiz
                </v-icon>
                <v-icon
                class="Delete"
                @click="delete3"
              >
                delete_forever
              </v-icon>
              </div>
              <v-card>
                <v-card-text class="grey lighten-3">
                  <v-flex>
                    <img src="../../assets/pictures/Memorandum/Eminem.jpg" alt="#" /><br />
                    <span style="font-size: 24px;">这位是<u>Eminem</u></span><br />
                  </v-flex>
                  <span>1.他是美国史上著名的白人说唱歌手</span><br />
                  <span>2.他曾多次获得了格莱美奖项</span>
                </v-card-text>
              </v-card>
            </v-expansion-panel-content>
            <v-dialog
              persistent max-width="800px"
              v-model="dialog3"
            >
              <v-card>
                <v-card-text>
                  <v-container grid-list-md>
                    <v-layout wrap>
                      <v-flex sm12 md12>
                        <v-text-field
                          solo class="elevation-5"
                          v-model="Title3"
                        >
                        </v-text-field>
                      </v-flex>
                      <v-flex
                        class="Textarea"
                        ref="editor3"
                      ></v-flex>
                    </v-layout>
                  </v-container>
                </v-card-text>
                <v-card-actions>
                  <v-spacer></v-spacer>
                  <v-btn
                    dark color="grey darken-4"
                    @click="Save"
                  >
                    保存
                  </v-btn>
                  <v-btn @click="hideDialog3">取消</v-btn>
                </v-card-actions>
              </v-card>
            </v-dialog>
          </v-expansion-panel>
        </v-flex>
      </v-layout>
      <v-layout>
        <v-flex>
          <v-flex>
            <v-btn
              block flat
              @click="dialog = true"
            >
              <v-icon>add</v-icon>
            </v-btn>
          </v-flex>
          <v-dialog
            persistent max-width="800px"
            v-model="dialog"
          >
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
                  <v-btn dark color="grey darken-4" @click="Save3">保存</v-btn>
                  <v-btn @click.native="hideDialog">取消</v-btn>
                </v-card-actions>
              </v-card>
            </v-form>
          </v-dialog>
        </v-flex>
      </v-layout>
    </v-container>
  </v-app>
</template>

<script>
import { minLength, maxLength } from 'vuelidate/lib/validators'
import E from 'wangeditor'

export default {
  validations: {
    text: { minLength: minLength(1), maxLength: maxLength(15) },
  },

  name: 'editor',
  name: 'editor1',
  name: 'editor2',
  name: 'editor3',

  data: () => ({
    text: '',
    dialog: false,
    dialog1: false,
    dialog2: false,
    dialog3: false,
    modify: true,
    save: false,
    Title1: '今天要开始学习《投资学》',
    Title2: '这张图片不错',
    Title3: '介绍我的偶像',
    Memorandum1: true,
    Memorandum2: true,
    Memorandum3: false
  }),

  mounted () {
    {
      var editor = new E(this.$refs.editor)
      // 忽略粘贴内容中的图片
      editor.customConfig.pasteIgnoreImg = true
      // 自定义菜单项
      editor.customConfig.menus = [
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
    }
    {
      var editor1 = new E(this.$refs.editor1)
      // 忽略粘贴内容中的图片
      editor1.customConfig.pasteIgnoreImg = true
      // 自定义菜单项
      editor1.customConfig.menus = [
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
      editor1.customConfig.linkImgCallback = function (url) {
        console.log(url) // url 即插入图片的地址
      }
      // 插入网络图片校验
      editor1.customConfig.linkImgCheck = function (src) {
        console.log(src)
        // 返回'true'则表示校验成功
        // 返回'校验失败'则表示校验失败
        return true
      }
      // editor.customConfig.onchange = (html) => {
      //   this.editorContent = html
      // }
      editor1.create()
    }
    {
      var editor2 = new E(this.$refs.editor2)
      // 忽略粘贴内容中的图片
      editor2.customConfig.pasteIgnoreImg = true
      // 自定义菜单项
      editor2.customConfig.menus = [
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
      editor2.customConfig.linkImgCallback = function (url) {
        console.log(url) // url 即插入图片的地址
      }
      // 插入网络图片校验
      editor2.customConfig.linkImgCheck = function (src) {
        console.log(src)
        // 返回'true'则表示校验成功
        // 返回'校验失败'则表示校验失败
        return true
      }
      // editor.customConfig.onchange = (html) => {
      //   this.editorContent = html
      // }
      editor2.create()
    }
    {
      var editor3 = new E(this.$refs.editor3)
      // 忽略粘贴内容中的图片
      editor3.customConfig.pasteIgnoreImg = true
      // 自定义菜单项
      editor3.customConfig.menus = [
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
      editor3.customConfig.linkImgCallback = function (url) {
        console.log(url) // url 即插入图片的地址
      }
      // 插入网络图片校验
      editor3.customConfig.linkImgCheck = function (src) {
        console.log(src)
        // 返回'true'则表示校验成功
        // 返回'校验失败'则表示校验失败
        return true
      }
      // editor.customConfig.onchange = (html) => {
      //   this.editorContent = html
      // }
      editor3.create()
    }
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
    showDialog1() {
      this.dialog1 = !this.dialog1
    },
    showDialog2() {
      this.dialog2 = !this.dialog2
    },
    showDialog3() {
      this.dialog3 = !this.dialog3
    },
    hideDialog1() {
      this.dialog1 = !this.dialog1
    },
    hideDialog2() {
      this.dialog2 = !this.dialog2
    },
    hideDialog3() {
      this.dialog3 = !this.dialog3
    },
    Modify() {
      this.save = !this.save
      this.modify = !this.modify
    },
    Save() {
      this.modify = !this.modify
      this.save = !this.save
    },
    Save3() {
      this.dialog = !this.dialog
      this.Memorandum3 = true
    },
    hideDialog() {
      this.text = ''
      this.$emit('hideDialog')
      this.dialog = !this.dialog
    },
    delete1() {
      this.Memorandum1 = false
    },
    delete2() {
      this.Memorandum2 = false
    },
    delete3() {
      this.Memorandum3 = false
    },
  }
}
</script>

<style scoped>
hr {
  margin-top: 10px;
}
.gap {
  margin-bottom: 30px;
  margin-bottom: 20px;
}
.Expired {
  color: #C62828;
}
.date {
  margin-left: 5px;
  font-size: 14px;
  color: #757575;
}
.Setting {
  position: absolute;
  right: 70px;
  opacity: 0;
}
.Setting:hover {
  opacity: 1;
}
.Delete {
  position: absolute;
  right: 30px;
  opacity: 0;
}
.Delete:hover {
  opacity: 1;
}
.Textarea {
  max-width: 760px;
}
</style>
