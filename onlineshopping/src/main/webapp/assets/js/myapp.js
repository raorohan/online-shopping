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
		
	case 'Manage Products':
		$("#manageproducts").addClass('active');
		break;

	default:
		if (menu == 'home')
			break;
		$("#listproduct").addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}
	
	
	
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

			lengthMenu : [ [ 3, 5, 7, -1 ],[ '3 Records', '5 Records', '7 Records', 'All Records' ] ],
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
					else { return data}
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


	//dismissing the alert
	var $alert = $('.alert');
	if($alert.length)
		{
		setTimeout(function(){
			
			$alert.fadeOut('slow');
		},3000)
		}
	
	
	// Showing Data at Manageproducts for Admin -- Start
	
	var $adminProductsTable = $('#adminProductsTable');
	// Excecute this code only when we have this particular table

	if ($adminProductsTable.length) {
		
		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';
		$adminProductsTable.DataTable({

			lengthMenu : [ [ 10, 20, 30, -1 ],[ '10 Records', '20 Records', '30 Records', 'All Records' ] ],
			pageLength : 30,
			ajax : {

				url : jsonUrl,
				dataSrc : ''
			},

			columns : [
			           
			           {
			        	   data: 'id'
			           },

			{
				data : 'code',
				mRender: function(data, type, row)
				{
					return '<img class="adminDataTableImg" src="' +window.contextRoot+ '/resources/images/'+data+'.jpg" />';
				}
			}, 
			{
				data : 'name'
			}, 
			{
				data : 'brand'
			}, 
			
			
			{
				data : 'quantity',
				mRender: function(data, type, row)
				{
					if(data < 1){
						return '<span style="color:red;">Out of Stock</span';
					}
					else { return data}
				},
			},
			
			{
				data : 'unitPrice',
					mRender:function(data,type,row)
					{
						return ' &#8377;' + data
					}
			}, 

		
			{
				data: 'active',
				bSortable: false,
				mRender: function(data, type, row)
				{
					var str = '';
					str += '<label class="switch">';
					if(data)
						{
							if(row.quantity > 1)
								{
								str += '<input type="checkbox"  checked="checked"  value="' +row.id+ '" />';
								}
						}
					else
						{
						str += '<input type="checkbox"   value="' +row.id+ '" />';
						}
					
					str += '<div class="slider round"></div></label>';
					return str;
				}
			},
			
			{
				data: 'id',
				bSortable: false,
				mRender: function(data, type, row)
				{
					var str = '';
					str += '<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-warning">';
					str += '<span class="glyphicon glyphicon-pencil "></span></a>';
					return str;
				}
			}

			],
			
			initComplete: function(){
				
				var api = this.api;
				$('.switch input[type="checkbox"]').on('change', function(){
					
					var checkbox = $(this);
					var checked= checkbox.prop('checked');
					// getting product id
					console.log(checked);
					var value = checkbox.prop('value');
					var dialogMessage = (checked)?'You want to activate the product?':'You want to deactivate the product?';
					
					var buttoncheck = confirm(dialogMessage);
					console.log(buttoncheck);
							if(buttoncheck)
								{
									var activationUrl = window.contextRoot + '/manage/product/' +value+ '/activation';
									$.post(activationUrl, function(data,status){
										
									});
									
								}
							else
								{
								checkbox.prop('checked', !checked);
								}
							

							
					
				});
			}

		});
		
		
		
	}
	
	// Showing Data at Manageproducts for Admin-- End
	
	
	
	
	
});

// Code for Category dialog creation

$(document).ready(function(){
	$("#myCategoryModal").on('click', function(){
		
		var wantToAddCategory = confirm("Add New Category");
		console.log(wantToAddCategory);
		
		if(wantToAddCategory)
			{
			var categoryAddUrl = window.contextRoot + '/manage/add/category';
			console.log(categoryAddUrl);
			$.post(categoryAddUrl, function(data,status){
				
			});
			}
		else
			{
			
			}
	});
	
});


