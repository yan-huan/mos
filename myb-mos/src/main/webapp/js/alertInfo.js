   function  alertInfo(info){
   	    	
   	    	var dialog = jDialog.alert(info,{},{
   				showShadow: false,// 不显示对话框阴影
   				buttonAlign : 'center',
   				events : {
   					show : function(evt){
   						var dlg = evt.data.dialog;
   					},
   					close : function(evt){
   						var dlg = evt.data.dialog;
   					},
   					enterKey : function(evt){
   					},
   					escKey : function(evt){
   						evt.data.dialog.close();
   					}
   				}
   			  });
   	    }
   function  alertInfo1(info){
	   
	   var dialog = jDialog.alert(info,{},{
		   showShadow: false,// 不显示对话框阴影
		   buttonAlign : 'center',
		   events : {
			   show : function(evt){
				   var dlg = evt.data.dialog;
			   },
			   close : function(evt){
				   var dlg = evt.data.dialog;
				   window.close();
			   },
			   enterKey : function(evt){
			   },
			   escKey : function(evt){
				   evt.data.dialog.close();
				   window.close();
			   }
		   }
	   });
   }
   //带连接的
   function  alertInfoAndHref(info,hre){
	    	
	   console.info(hre);
	    	var dialog = jDialog.alert(info,{},{
				showShadow: false,// 不显示对话框阴影
				buttonAlign : 'center',
				events : {
					show : function(evt){
						var dlg = evt.data.dialog;
					},
					close : function(evt){
						window.location.href=hre;
						var dlg = evt.data.dialog;
					},
					enterKey : function(evt){
						window.location.href=hre;
					},
					escKey : function(evt){
						window.location.href=hre;
						evt.data.dialog.close();
					}
				}
			  });
	    }