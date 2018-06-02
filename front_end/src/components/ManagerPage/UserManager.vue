<template>
  <v-app id="inspire">
    <v-container fluid>
      <v-layout class="gap">
        <v-flex>
          <h2>用户管理</h2>
        </v-flex>
      </v-layout>
      <v-divider></v-divider>
      <v-layout class="gap">
        <!-- <v-data-table
          class="elevation-1"
          item-key="name"
          v-model="selected"
          :items="users"
          :headers="headers"
          :pagination.sync="pagination"
        >
          <template slot="headers">
            <tr>
              <th
                v-for="header in headers"
                :key="header.text"
                :class="['column sortable', pagination.descending ? 'desc' : 'asc', header.value === pagination.sortBy ? 'active' : '']"
              >
                {{ header.text }}
              </th>
            </tr>
          </template>
          <template
            slot="items" slot-scope="props"
            v-for="user in users"
          >
            <tr
              :active="selected"
              :key="user.index">
              <td>{{ user.userEmail }}</td>
              <td>{{ user.userName }}</td>
              <td>{{ user.userPhone }}</td>
            </tr>
          </template>
        </v-data-table> -->
        <v-data-table
          v-model="selected"
          :headers="headers"
          :items="desserts"
          :pagination.sync="pagination"
          select-all
          item-key="name"
          class="elevation-1"
        >
          <template slot="headers" slot-scope="props">
            <tr>
              <!-- <th>
                <v-checkbox
                  :input-value="props.all"
                  :indeterminate="props.indeterminate"
                  primary
                  hide-details
                  @click.native="toggleAll"
                ></v-checkbox>
              </th> -->
              <th
                v-for="header in props.headers"
                :key="header.text"
                :class="['column sortable', pagination.descending ? 'desc' : 'asc', header.value === pagination.sortBy ? 'active' : '']"
                @click="changeSort(header.value)"
              >
                <!-- <v-icon small>arrow_upward</v-icon> -->
                {{ header.text }}
              </th>
            </tr>
          </template>
          <template slot="items" slot-scope="props">
            <tr :active="props.selected" @click="props.selected = !props.selected">
              <!-- <td>
                <v-checkbox
                  :input-value="props.selected"
                  primary
                  hide-details
                ></v-checkbox>
              </td> -->
              <!-- <td>{{ props.item.name }}</td> -->
              <td class="text-xs-right">{{ props.item.UserCreateDate }}</td>
              <td class="text-xs-right">{{ props.item.UserEmail }}</td>
              <td class="text-xs-right">{{ props.item.Username }}</td>
              <td class="text-xs-right">{{ props.item.UserPhone }}</td>
            </tr>
          </template>
        </v-data-table>
      </v-layout>
      <div class="GAP"></div>
      <v-layout class="gap">
        <v-flex>
          <h2>冗余清除</h2>
        </v-flex>
      </v-layout>
      <v-divider></v-divider>
      <v-btn
        outline color="red" class="DeleteButton"
        @click="deleteRedundancy"
      >
        删除系统冗余数据
      </v-btn>
    </v-container>
  </v-app>
</template>

<script>
export default {
  data: () => ({
    pagination: {
      sortBy: 'name'
    },
    selected: [],
    headers: [
      // {
      //   text: 'Dessert (100g serving)',
      //   align: 'left',
      //   value: 'name'
      // },
      { text: '创建日期', value: 'UserCreateDate' },
      { text: '用户邮箱', value: 'UserEmail' },
      { text: '用户昵称', value: 'Username' },
      { text: '手机号码', value: 'UserPhone' }
    ],
    desserts: [
      {
        value: false,
        UserCreateDate: '2018-05-21',
        UserEmail: 'cjh328@qq.com',
        Username: '陈嘉辉',
        UserPhone: '18576760917'
      },
      {
        value: false,
        UserCreateDate: '2018-05-28',
        UserEmail: 'dyh330@163.com',
        Username: '邓煜豪',
        UserPhone: '13555555555'
      },
      {
        value: false,
        UserCreateDate: '2018-05-20',
        UserEmail: 'lye328@qq.com',
        Username: '梁烨文',
        UserPhone: '13688605432'
      },
      {
        value: false,
        UserCreateDate: '2018-05-28',
        UserEmail: 'wpy329@163.com',
        Username: '魏培勇',
        UserPhone: '13088888888'
      },
      {
        value: false,
        UserCreateDate: '2018-05-24',
        UserEmail: 'wyc328@qq.com',
        Username: '韦英财',
        UserPhone: '13533880514'
      },
      {
        value: false,
        UserCreateDate: '2018-05-14',
       UserEmail: 'xzw329@163.com',
        Username: '谢志伟',
        UserPhone: '13000000000'
      },
      {
        value: false,
        UserCreateDate: '2018-05-20',
        UserEmail: 'zeroyip0917@gmail.com',
        Username: 'ZeroYip0917',
        UserPhone: '13038870917'
      },
      {
        value: false,
        UserCreateDate: '2018-05-05',
        UserEmail: 'zeroyip@foxmail.com',
        Username: 'ZeroYip',
        UserPhone: '13038875292'
      }
    ]
  }),

  mounted () {
    this.$nextTick(function () {
      this.findAllUser()
    })
  },

  methods: {
    findAllUser () {
      var that = this

      this.axios({
        method: 'GET',
        url: '/manager/findalluser',
        data: {},
        dataType: 'json'
      })
      .then(function (response) {
        that.users = response.data

        console.log(response.data)
      })
      .catch(function (error) {
        console.log(error)
      })
    },
    deleteRedundancy () {
      var that = this

      this.axios({
        method: 'DELETE',
        url: '/manager/deleteredundancy',
        data: {},
        dataType: 'json'
      })
      .then(function (response) {
      })
      .catch(function (error) {
        console.log(error)
      })
    }
  },

  props: {
    source: String
  }
}
</script>

<style scoped>
hr {
  margin-top: 5px;
  margin-bottom: 8px;
}
.gap {
  margin-bottom: 20px;
}
.GAP {
  height: 60px;
}
.DeleteButton {
  width: 300px;
}
</style>
