class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		/*"/servidor"(controller:"servidor"){
			action = [GET: "showInfo", PUT: "getStatus", POST: "startServer", DELETE: "stopServer"]
		}*/
		
		"/"(view:"/index")
		"500"(view:'/error')
	}
}
