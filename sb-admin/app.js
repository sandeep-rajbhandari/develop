/**
 * Created by srajbhandari on 10/10/14.
 */
var app=angular.module('appStore',['ui.router']);

app.factory('Data',function(){
    return{selectedCluster:""}
})
app.controller('clusterName',function($scope,Data){
$scope.clusterList=[
    {name:'cluster1',ip:'192.168.1.1',colour:'red'},
    {name:'cluster2',ip:'192.168.1.2',colour:'green'},
    {name:'cluster2',ip:'192.168.1.2',colour:'green'},
    {name:'cluster2',ip:'192.168.1.2',colour:'green'},
    {name:'cluster3',ip:'192.168.1.3',colour:'yellow'}

]
    $scope.gone=function(clusterName){
        Data.selectedCluster=clusterName;
      $scope.addClass('active')
    }

})

