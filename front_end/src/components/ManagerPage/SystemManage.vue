<template>
  <v-app id="inspire">
    <v-container fluid>
      <v-layout class="gap">
        <v-flex>
          <h2>过滤器管理</h2>
        </v-flex>
      </v-layout>
      <v-divider></v-divider>
      <v-card width="600px">
        <v-card-title>
          <v-select
            chips clearable tags solo label="Your favorite hobbies"
            prepend-icon="filter_list"
            append-icon=""
            v-model="chips"
          >
            <template slot="selection" slot-scope="data">
              <v-chip
                :selected="data.selected"
                close
                @input="remove(data.item)"
              >
                <strong>{{ data.item }}</strong>&nbsp;
                <span>(interest)</span>
              </v-chip>
            </template>
          </v-select>
        </v-card-title>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn>提交</v-btn>
        </v-card-actions>
      </v-card>
    </v-container>
  </v-app>
</template>

<script>
  export default {
    data: () => ({
      selected: [],
      chips: ['优先级1', '优先级2', '优先级3']
    }),

    methods: {
      remove (item) {
        this.chips.splice(this.chips.indexOf(item), 1)
        this.chips = [...this.chips]
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
</style>
