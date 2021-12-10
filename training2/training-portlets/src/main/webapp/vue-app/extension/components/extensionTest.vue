<template>
  <div class="d-inline-flex ms-lg-4">
    <!-- Added for mobile -->
    <v-tooltip bottom>
      <template v-slot:activator="{ on, attrs }">
        <v-btn
          :id="`Test${activityId}`"
          class="pa-0 mt-0"
          text
          link
          small
          v-on="on"
          @click="increaseCounter"
        >
          <div class="d-flex flex-lg-row flex-column">
            <v-icon
              class="baseline-vertical-align"
              size="14"
            >
              fa-thumbs-up
            </v-icon>
            <span class="mx-auto mt-1 mt-lg-0 ms-lg-2">
              {{ $t('sample.i18n.test') }}
            </span>
          </div>
        </v-btn>
      </template>
      <span>
        {{ $t('sample.i18n.test') }}
      </span>
    </v-tooltip>
  </div>
</template>
<script>

export default {
  data: () => ({
    counter: 0,
  }),
  methods: {
    increaseCounter() {
      this.counter ++;
      alert(this.counter);
    }
  },
};
</script>
