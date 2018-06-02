<template>
  <v-app id="inspire">
    <v-container fluid>
      <v-layout class="gap">
        <v-flex>
          <h2>未来7天</h2>
        </v-flex>
      </v-layout>
      <FirstDay></FirstDay>
      <SecondDay></SecondDay>
      <ThirdDay></ThirdDay>
      <FourthDay></FourthDay>
      <FifthDay></FifthDay>
      <SixthDay></SixthDay>
      <SeventhDay></SeventhDay>
    </v-container>
  </v-app>
</template>

<script>
import FirstDay from "../../components/SevenDays/FirstDay"
import SecondDay from "../../components/SevenDays/SecondDay"
import ThirdDay from "../../components/SevenDays/ThirdDay"
import FourthDay from "../../components/SevenDays/FourthDay"
import FifthDay from "../../components/SevenDays/FifthDay"
import SixthDay from "../../components/SevenDays/SixthDay"
import SeventhDay from "../../components/SevenDays/SeventhDay"

export default {
  components: {
    FirstDay,
    SecondDay,
    ThirdDay,
    FourthDay,
    FifthDay,
    SixthDay,
    SeventhDay
  },

  data: () => ({
  }),

  methods: {
  }
}
</script>

<style scoped>
.gap {
  margin-bottom: 15px;
}
</style>
