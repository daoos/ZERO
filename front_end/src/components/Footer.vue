<template>
  <v-footer>
    <v-card flat tile class="flex">
      <v-card-title class="blue dark-2 white--text">
        <strong class="subheading">点击按钮并分享给您的朋友们！</strong>
        <v-spacer></v-spacer>
        <v-btn v-for="icon in icons" :key="icon" icon dark class="mx-3">
          <v-icon size="24px">{{ icon }}</v-icon>
        </v-btn>
      </v-card-title>
      <v-card-text class="CompanyLogo grey lighten-3">
        <a href="http://www.zeroyip.com"><img height="60px" src="../assets/pictures/Welcome/Logo/ZEROYIP.COM Logo.png"/></a>
      </v-card-text>
    </v-card>
  </v-footer>
</template>

<script>
export default {
  data: () => ({
    icons: ['fab fa-weixin', 'fab fa-weibo', 'fab fa-google-plus', 'fab fa-tumblr', 'fab fa-instagram']
  })
}
</script>

<style scoped>
v-footer {
  height: auto;
}
.CompanyLogo {
  text-align: center;
}
</style>

