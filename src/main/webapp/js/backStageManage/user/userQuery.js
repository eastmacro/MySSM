$(document).ready(function(){



    var table = $('#myTable').DataTable({responsive: true});
    //给行绑定选中事件
    $('#myTable').on('click','tr',function() {
        if ($(this).hasClass('selected')) {
            $(this).removeClass('selected');
        }
        else {
            table.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    });
    //给按钮绑定点击事件
    $("#table_id_example_button").click(function(){
        var column1 = table.row('.selected').data().column1;
        var column2 = table.row('.selected').data().column2;
        alert("第一列内容："+column1 + "；第二列内容： " + column2);
    });







    $(".edit").click(function(){
	  var userId = $(this).attr("id");
	 // window.location="/MyDemo/manage/edit?id="+userId;
	  window.location="edit?id="+userId;
  });
  
  $(".delete").click(function(){
	  alert("delete");
  });


});