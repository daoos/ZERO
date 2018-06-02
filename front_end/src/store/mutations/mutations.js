export default {
  /**
  * 登入操作
  * 保存token至localStorage和Vuex的state中,即时关闭浏览器也不会注销账户
  */
  login: (state, data) => {
    localStorage.token = data
    state.token = data
  },
  managerLogin: (state, data) => {
    localStorage.manager_token = data
    state.manager_token = data
  },
  /**
   * 登出操作
   * 只有当用户进行注销账户的操作，才会把保存在localStorage和Vuex的state的token清除
   */
  logout: (state) => {
    localStorage.removeItem('token')
    state.token = null
  },
  managerLogout: (state) => {
    localStorage.removeItem('manager_token')
    state.manager_token = null
  },
  saveTodo: (state, data) => {
    localStorage.todo = data
    state.todo = data
  },
  saveExpiredTodo: (state, data) => {
    localStorage.expiredTodo = data
    state.expiredTodo = data
  },
  saveFinishedTodo: (state, data) => {
    localStorage.finishedTodo = data
    state.finishedTodo = data
  },
  saveInventory: (state, data) => {
    localStorage.inventory = data
    state.inventory = data
  },
  saveUserPermission: (state, data) => {
    sessionStorage.userPermission = data
    state.userPermission = data
  },
  saveGroups: (state, data) => {
    localStorage.groups = data
    state.groups = data
  },
  saveMessages: (state, data) => {
    localStorage.messages = data
    state.messages = data
  }
}
