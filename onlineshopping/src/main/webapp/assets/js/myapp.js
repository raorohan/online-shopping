$(function() {

	switch (menu) {

	case 'About Us':
		$("#about").addClass('active');
		break;

	case 'Contact Us':
		$("#contact").addClass('active');
		break;

	case 'All Products':
		$("#listproduct").addClass('active');
		break;

	default:
		if (menu == 'home')
			break;
		$("#listproduct").addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}
});

/* Code for DataTable plugin */

var jsonUrl = '';
if (window.categoryId) {

	jsonUrl = window.contextRoot + '/json/data/category/' + window.categoryId
			+ '/products';
	console.log(jsonUrl);
} else {
	jsonUrl = window.contextRoot + '/json/data/all/products';

}

var $table = $('#productListTable');
// Excecute this code only when we have this particular table

if ($table.length) {
	$table.DataTable({

		lengthMenu : [ [ 3, 5, 7, -1 ],
				[ '3 Records', '5 Records', '7 Records', 'All Records' ] ],
		pageLength : 5,
		ajax : {

			url : jsonUrl,
			dataSrc : ''
		},

		columns : [

		{
			data : 'code',
			mRender: function(data, type, row)
			{
				return '<img class="dataTableImg" src="' +window.contextRoot+ '/resources/images/'+data+'.jpg" />';
			}
		}, 
		{
			data : 'name'
		}, 
		{
			data : 'brand'
		}, 
		{
			data : 'unitPrice',
				mRender:function(data,type,row)
				{
					return ' &#8377;' + data
				}
		}, 
		
		

		 {
			data : 'quantity',
			mRender: function(data, type, row)
			{
				if(data < 1){
					return '<span style="color:red;">Out of Stock</span';
				}
				else {data;}
			},
		},

		/*{
			data : 'views'
		},*/
		{
			data : 'id',
			bSortable: false,
			mRender: function(data, type, row)
			{
				var str ='';
				str+= '<a href=" '+ window.contextRoot +'/show/'+ data +'/product" class="btn btn-primary">View &#160;</a>';
				if(row.quantity < 1){
					str+= '<a href="javascript:void(0)" class="btn btn-success disabled"><strike><span class="glyphicon glyphicon-shopping-cart">Cart</span></strike></a>';
					
				}
				else {
					str+= '<a href=" '+ window.contextRoot +'/cart/add/'+ data +'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart">Cart</span></a>';
					
				}
				return str;
			},
		}

		]

	});
}
