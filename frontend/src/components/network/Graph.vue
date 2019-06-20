<template>
<v-container>
<d3-network :net-nodes="nodes" :net-links="links" :options="options"></d3-network>
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
        { id: 3,},
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
      options:
      {
        force: 3000,
        nodeSize: 20,
        nodeLabels: true,
        linkWidth:5
      }
      }
    },
    methods: {
      //
    },
    computed:{
    //
  }

  }
</script>
<style>
canvas{
    position:absolute;
    top:0;
    left:0
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
