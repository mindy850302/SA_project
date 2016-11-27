$('#myTabs a').click(function (e) {
  e.preventDefault()
  $(this).tab('show')
})
$('#mydelete').on('shown.bs.modal', function () {
  $('#myInput').focus()
})
$('#myModify').on('shown.bs.modal', function () {
  $('#myInput').focus()
})
$('#myAdd').on('shown.bs.modal', function () {
  $('#myInput').focus()
})
$('#myAddProduct').on('shown.bs.modal', function () {
  $('#myInput').focus()
})
$('#mydeleteProduct').on('shown.bs.modal', function () {
  $('#myInput').focus()
})
$('#myModifyProduct').on('shown.bs.modal', function () {
  $('#myInput').focus()
})
$('#myAddComment').on('shown.bs.modal', function () {
  $('#myInput').focus()
})
$('#mydeleteComment').on('shown.bs.modal', function () {
  $('#myInput').focus()
})
$('#myModifyComment').on('shown.bs.modal', function () {
  $('#myInput').focus()
})
$('#myAddInventory').on('shown.bs.modal', function () {
  $('#myInput').focus()
})
$('#myRemoveProduct').on('shown.bs.modal', function () {
  $('#myInput').focus()
})
