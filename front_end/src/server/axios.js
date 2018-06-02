import axios from 'axios'
import store from '../store/store'
import mutations from '../store/mutations/mutations'
import router from '../router/router'

/**
 * axios 配置
 * @timeout  设置axios请求的超时时间
 * @baseURL  设置axios请求的URL前缀
 */
axios.defaults.timeout = 5000
axios.defaults.baseURL = 'http://localhost:9090'
axios.defaults.headers.post['Content-Type'] = 'application/json ; charset=UTF-8'

// 创建一个axios实例
const instance = axios.create({
  timeout: 6000,
  baseURL: 'http://localhost:9090',
  headers: 'application/json ; charset=UTF-8',
  // headers: 'X-Auth-Token',
  withCredentials: true,
  responseType: 'json'
})

axios.interceptors.request.use = instance.interceptors.request.use

// 配置HTTP Request 拦截器
instance.interceptors.request.use(
  // 发送请求前所进行的行为
  config => {
    if (store.state.token) {
      config.headers.Authorization = `token ${store.state.token}`
    }
    return config
  },
  // 对请求错误的处理行为
  error => {
    return Promise.reject(error)
  })

// 配置HTTP Response 拦截器
instance.interceptors.response.use(
  // 对响应数据的处理行为
  response => {
    return response
  },
  // 对响应错误所进行的行为
  error => {
    if (error.response) {
      switch (error.response.status) {
        case 401:
          // 401(清除token并跳转至登录页面)
          store.commit(mutations.logout)
          router.replace({
            path: '/login',
            query: { redirect: router.currentRoute.fullPath }
          })
      }
    }
    // return Promise.reject(error.response.data)
    return Promise.reject(error)
  })

export default axios
