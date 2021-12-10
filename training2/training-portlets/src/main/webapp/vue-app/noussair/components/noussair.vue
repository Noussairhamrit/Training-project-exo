<template>
  <div class="helloContaner">
    <p>noussair portlet</p>
    <!--    <form>-->
    <!--    <input v-model.lazy.trim="id">-->
    <!--    <button type="submit" @click.prevent="onSubmit">get</button>-->
    <!--    </form>-->
    <p>{{ apiResponse }}</p>
    <!--    <v-data-table-->
    <!--        :headers="headers"-->
    <!--        :items="api"-->
    <!--        class="elevation-1"-->
    <!--    >-->
    <!--      <template v-slot:api.id="{ api }">-->
    <!--        <v-chip-->
    <!--            :color="getColor(api.id)"-->
    <!--            dark-->
    <!--        >-->
    <!--          {{ api.id }}-->
    <!--        </v-chip>-->
    <!--      </template>-->
    <!--    </v-data-table>-->
    <!--    <v-data-table-->
    <!--      :headers="headers"-->
    <!--      :items="apiResponse"-->
    <!--      class="elevation-1" />-->
  </div>
</template>
<script>
import {testapinoussair} from '../../../js/trainingService';
export default {
  data(){
    return {
      id: Number,

      userObject: {
        id: Number,
        name: String
      },
      apiResponse: {},
      headers: [
        {text: 'id', value: 'id'},
        {text: 'name', value: 'name'}
      ]
    };
  },
  mounted() {
    this.testapi();

  },
  methods: {
    testapi: function () {
      // eslint-disable-next-line no-magic-numbers
      return testapinoussair(2).then(data => {
        // this.userObject.id = data.id;
        // this.userObject.name = data.name;
        this.apiResponse=data;

     
      });
    },
    // onSubmit(){
    //   console.log(this.id);
    //   this.testapi();
    //   console.log(this.userObject.id);
    //
    // }
  }
};
</script>