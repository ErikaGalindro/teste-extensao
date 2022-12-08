//criação do modulo principal da aplicação
var AppCrud = angular.module("AppCrud", []);

// Criação de controller
AppCrud.controller("indexController", function($scope, $http) {

	$scope.pessoas = [];
	$scope.pessoa = {};

	// Salvar Dados
	$scope.Salvar = function() {

		$http({
			method: $scope.pessoa.id ? 'PUT' : 'POST',
			url: $scope.pessoa.id ? '/pessoas/' + $scope.pessoa.id : '/pessoas',
			data: $scope.pessoa
		}).then(function(response) {

			$scope.ListaDePessoas();


		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});
		$scope.pessoa = {};

	}
	// Carregar Dados
	$scope.ListaDePessoas = function() {

		$http({
			method: 'GET',
			url: '/pessoas'
		}).then(function(response) {
			$scope.pessoas = response.data;

		}, function(response) {
			alert("falha ao buscar lista de pessoas");
		});

	};


	// Excluir Dados
	$scope.ExcluirPessoa = function(pessoa) {

		$http({
			method: 'DELETE',
			url: '/pessoas/' + pessoa.id
		}).then(function(response) {
			alert("Excluido com sucesso!");
			$scope.ListaDePessoas();
		}, function(response) {
			alert("Falha ao excluir!");

		});

	}

	// Alterar Dados
	$scope.AlterarPessoa = function(modificarPessoa) {
		$scope.pessoa = angular.copy(modificarPessoa);

	};

	$scope.ListaDePessoas();

});