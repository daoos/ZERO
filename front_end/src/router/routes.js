import ManagerLogin from '@/views/ManagerPage/ManagerLogin'
import ManagerPage from '@/views/ManagerPage/ManagerPage'
import UserManager from '@/../src/components/ManagerPage/UserManager'
import Announcement from '@/../src/components/ManagerPage/Announcement'
import SystemManage from '@/../src/components/ManagerPage/SystemManage'
import Welcome from '@/views/WelcomePage/Welcome'
import Login from '@/views/EnterPage/Login'
import Register from '@/views/EnterPage/Register'
import Reset from '@/views/EnterPage/Reset'
import Index from '@/views/Index/Index'
import Memorandum from '@/views/Index/Memorandum'
import Today from '@/views/Index/Today'
import SevenDays from '@/views/Index/SevenDays'
import Finished from '@/views/Index/Finished'
import Filter1 from '@/../src/components/Filter/Filter1'
import Filter2 from '@/../src/components/Filter/Filter2'
import Filter3 from '@/../src/components/Filter/Filter3'
import Teamwork from '@/views/TeamworkPage/Teamwork'
import Setting from '@/views/Index/SettingPage/Setting'
import PersonalSetting from '@/views/Index/SettingPage/PersonalSetting'
import GeneralSetting from '@/views/Index/SettingPage/GeneralSetting'
import ReminderRules from '@/views/Index/SettingPage/ReminderRules'

export default [
  {
    path: '/managerlogin',
    name: 'managerlogin',
    component: ManagerLogin
  },
  {
    path: '/managerpage',
    name: 'managerpage',
    meta: {
      // 添加该字段表示需要登录后才能发生跳转
      requireAuth: true
    },
    component: ManagerPage,
    children: [
      {
        path: '/usermanager',
        name: 'usermanager',
        meta: {
          requireAuth: true
        },
        component: UserManager
      },
      {
        path: '/announcement',
        name: 'announcement',
        meta: {
          requireAuth: true
        },
        component: Announcement
      },
      {
        path: '/systemmanage',
        name: 'systemmanage',
        meta: {
          requireAuth: true
        },
        component: SystemManage
      }
    ]
  },
  {
    path: '/',
    redirect: '/welcome'
  },
  {
    path: '/welcome',
    name: 'welcome',
    component: Welcome
  },
  {
    path: '/login',
    name: 'login',
    component: Login
  },
  {
    path: '/register',
    name: 'register',
    component: Register
  },
  {
    path: '/reset',
    name: 'reset',
    component: Reset
  },
  {
    path: '/index',
    name: 'index',
    meta: {
      requireAuth: true
    },
    component: Index,
    children: [
      {
        path: '/memorandum',
        name: 'memorandum',
        meta: {
          requireAuth: true
        },
        component: Memorandum
      },
      {
        path: '/today',
        name: 'today',
        meta: {
          requireAuth: true
        },
        component: Today
      },
      {
        path: '/sevendays',
        name: 'sevendays',
        meta: {
          requireAuth: true
        },
        component: SevenDays
      },
      {
        path: '/finished',
        name: 'finished',
        meta: {
          requireAuth: true
        },
        component: Finished
      },
      {
        path: '/filter1',
        name: 'filter1',
        meta: {
          requireAuth: true
        },
        component: Filter1
      },
      {
        path: '/filter2',
        name: 'filter2',
        meta: {
          requireAuth: true
        },
        component: Filter2
      },
      {
        path: '/filter3',
        name: 'filter3',
        meta: {
          requireAuth: true
        },
        component: Filter3
      }
    ]
  },
  {
    path: '/teamwork',
    name: 'teamwork',
    meta: {
      requireAuth: true
    },
    component: Teamwork
  },
  {
    path: '/setting',
    name: 'setting',
    component: Setting,
    meta: {
      requireAuth: true
    },
    children: [
      {
        path: '/personalSetting',
        name: 'personalSetting',
        component: PersonalSetting
      },
      {
        path: '/generalSetting',
        name: 'generalSetting',
        component: GeneralSetting
      },
      {
        path: '/reminderRules',
        name: 'reminderRules',
        component: ReminderRules
      }
    ]
  }
]
