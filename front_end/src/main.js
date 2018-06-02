import Vue from 'vue'
import VueRouter from 'vue-router'
import createRouter from './router/router'
import Vuex from 'vuex'
import createStore from './store/store'
import axios from './server/axios'
import Vuelidate from 'vuelidate'
import Vuetify from 'vuetify'
import App from './App'

Vue.config.productionTip = false
Vue.use(VueRouter)
Vue.use(Vuex)
Vue.use(Vuelidate)
Vue.use(Vuetify)

const router = createRouter()
/**
 * 使用vue-router所提供的beforeEach()钩子函数对路由进行是否需要登录的判断
 * @to           即将跳转的目标路由
 * @from         当前导航将要离开的路由
 * @next         需要调用此方法以resolve钩子，执行效果依赖next方法的调用参数
 * @next()       进行管道中的下一个钩子(若全部钩子执行完毕，则导航状态更改为confirmed[确认的])
 * @next(false)  中断当前的导航(若浏览器发生URL变化[可能是用户手动按下了后退按钮],那么URL将重置到fro 路由对应的地址)
 * next('/')或next({ path: '/'})  跳转到一个不同的地址(当前导航被中断,然后进行一个新的导航)
 */
router.beforeEach((to, from, next) => {
  // 判断该路由是否需要登录权限
  if (to.meta.requireAuth) {
    // 通过Vuex state获取当前的token是否存在
    if (store.state.token || localStorage.token) {
      next()
    } else {
      next({
        path: '/login',
        // 将跳转的路由path作为参数，登录成功后跳转到该路由
        query: {redirect: to.fullPath}
      })
    }
  } else {
    next()
  }
})

const store = createStore()

// 将axios挂载到protptype,在组件中可以直接使用this.axios访问
Vue.prototype.axios = axios

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  axios,
  render: h => h(App)
}).$mount('#app')
