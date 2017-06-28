app.factory('homeService', ['$http', function($http) { 
  return $http.get('/WebProjekat/HomeAPIServlet') 
            .success(function(data) { 
              return data; 
            }) 
            .error(function(err) { 
              return err;
            }); 
}]);