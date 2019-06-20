<template>
<v-container>
    <v-layout row wrap>
      <ul class="menu">
        <li>
          <label> Node size  </label>
          <input type="range" min="1" max="100" v-model='nodeSize' /> {{ options.nodeSize }}
        </li>  
      </ul>
    </v-layout>
    <v-layout row wrap>
        <d3-network :net-nodes="nodes" :net-links="links" :options="options"></d3-network>
    </v-layout>
</v-container>
</template>

<script >
  import D3Network from 'vue-d3-network'

  export default {
    name: 'NetworkGraph',
    components: {
      D3Network
    },
    data() {
      return {
        nodes: [
        { id: 1, name: 'my node 1' },
        { id: 2, name: 'my node 2' },
        { id: 3 },
        { id: 4 },
        { id: 5 },
        { id: 6 },
        { id: 7 },
        { id: 8 },
        { id: 9 }
      ],
      links: [
        { sid: 1, tid: 2,},
        { sid: 2, tid: 8,},
        { sid: 3, tid: 4,},
        { sid: 4, tid: 5 },
        { sid: 5, tid: 6 },
        { sid: 7, tid: 8 },
        { sid: 5, tid: 8 },
        { sid: 3, tid: 8 },
        { sid: 7, tid: 9 }
      ],
      nodeSize:20,

      }
    },
    methods: {
      //
    },
    computed:{
    options(){
      return{
        force: 3000,
        size:{ w:1000, h:600},
        nodeSize: this.nodeSize,
        nodeLabels: true,
        linkWidth:3
      }
    }
  }

  }
</script>
<style>
ul.menu {
  list-style: none;
  position: absolute;
  z-index: 100;
  min-width: 20em;
  text-align: left;
}
ul.menu li{
  margin-top: 1em;
  position: relative;
}
.net{
    height:100%;
    margin:0
}
.node{
    stroke:rgba(18,120,98,.7);
    stroke-width:3px;
    -webkit-transition:fill .5s ease;
    transition:fill .5s ease;
    fill:#dcfaf3
    }
.node.selected{
    stroke:#caa455
}
.node.pinned{
    stroke:rgba(190,56,93,.6)
}
.link{
    stroke:rgba(18,120,98,.3)
}
.link,.node{
    stroke-linecap:round
}
.link:hover,.node:hover{
    stroke:#be385d;
    stroke-width:5px
}
.link.selected{
    stroke:rgba(202,164,85,.6)
}
.curve{
    fill:none
}
.link-label,.node-label{
    fill:#127862
}
.link-label{
    -webkit-transform:translateY(-.5em);
    transform:translateY(-.5em);
    text-anchor:middle
}

</style>
