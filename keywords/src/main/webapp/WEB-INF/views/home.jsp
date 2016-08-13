<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ taglib uri="http://www.springframework.org/security/tags" --%>
<%-- 	prefix="sec"%> --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<dir ng-app="mainApp" ng-controller="callResult">
		{{vari.name}}

		<input type="text" ng-model="listKey" name="listKey">
		<input type="button" ng-click="callresultfn()" value="Search">
		<table>
			<tr>
				<td>{{titleSearch.location}}</td>
				<td><select ng-model="locationId" style="width: 300px;">
						<option ng-repeat="location in locations"
							value="{{location.locationId}}"
							ng-selected="location.locationId==locationIdDefault">{{location.locationName}}</option>
				</select></td>
			</tr>
			<tr>
				<td>{{titleSearch.language}}</td>
				<td><select ng-model="languageId" style="width: 300px;">
						<option ng-selected="{{language.languageId==languageIdDefault}}"
							ng-repeat="language in languages" value="{{language.languageId}}">{{language.languageName}}</option>
				</select></td>
			</tr>
			<tr>
				<td>{{titleSearch.mode}}</td>
				<td><select ng-model="modesearchId" style="width: 300px;">
						<option ng-repeat="modesearch in modesearchs"
							value="{{modesearch.modesearchId}}"
							ng-selected="modesearch.modesearchId==modesearchIdDefault">{{modesearch.modesearchName}}</option>
				</select></td>
			</tr>
		</table>
		<table>
			<tr>
				<td>
					<table>
						<tr>

							<th><input type="checkbox" ng-model="all"></th>
							<th>Keywords</th>
							<th>Total search</th>
							<th>Competition</th>
							<th>CPC</th>
						</tr>
						<tr ng-repeat="result in results">

							<td><input type="checkbox"
								ng-checked="checklist.list.indexOf(result)>-1"
								ng-click="addDataCheckTRUEs(result)"></td>
							<td>{{result.keyword}}</td>
							<td>{{result.totalsearchs}}</td>
							<td>{{result.competition}}</td>
							<td>{{result.cpc}}</td>
						</tr>
					</table>

				</td>
				<td><textarea ng-model="textAreaContent" rows="20" cols="50"></textarea></td>
			</tr>
		</table>
	</dir>
	<script type="text/javascript">
		var mainApp = angular.module('mainApp', []);
		mainApp
				.controller(
						'callResult',
						function($scope, $http) {

							$scope.titleSearch = {
								location : 'Location',
								language : 'Language',
								mode : 'Mode search'
							};

							$scope.listKey = "Ronaldo, Messi, Bale, Neymar, Suarez";
							$scope.textAreaContent = "";

							//bind checklist
							$scope.checklist = {
								list : []
							};
							$scope.addDataCheckTRUEs = function(result) {
								var index = $scope.checklist.list
										.indexOf(result);
								if (index <= -1) {
									console.log("push");
									$scope.checklist.list.push(result);
								} else {
									console.log("remove");
									$scope.checklist.list.splice(index, 1);
								}

								$scope.textAreaContent = "";
								for (i = 0; i < $scope.checklist.list.length; i++) {

									$scope.textAreaContent += $scope.checklist.list[i].keyword
											+ ",\n";
								}
							};

							$scope.getAlldata = function() {
								$http(
										{
											method : "POST",
											url : "alldata",
											headers : {
												'Content-Type' : 'application/json; charset=UTF-8'
											},
										})
										.then(
												function successCallback(
														response) {
													$scope.alldata = response.data;
													//Set default value init
													//$scope.modesearchIdDefault = $scope.modesearchs[1].modesearchId;
													$scope.modesearchs = $scope.alldata.modesearch;
													$scope.locations = $scope.alldata.alllacation;
													$scope.languages = $scope.alldata.alllanguage;
													$scope.defaultInVn = $scope.alldata.defaultInVn;
													$scope.defaultOutVn = $scope.alldata.defaultOutVn;

													$scope.modesearchIdDefault = '2';
													$scope.modesearchId = $scope.modesearchIdDefault;
													$scope.locationIdDefault = '2840';
													$scope.locationId = $scope.locationIdDefault;
													$scope.languageIdDefault = '1000';
													$scope.languageId = $scope.languageIdDefault;
													$scope.callresultfn();
												},
												function errorCallback(response) {
													console.log("error");
												});
							};

							$scope.callresultfn = function() {
								$scope.data = {
									listKey : $scope.listKey,
									locationId : $scope.locationId,
									languageId : $scope.languageId,
									modesearchId : $scope.modesearchId
								};
								$http(
										{
											method : "POST",
											url : "resultws",
											data : $scope.data,
											headers : {
												'Content-Type' : 'application/json; charset=UTF-8'
											},
										})
										.then(
												function successCallback(
														response) {
													$scope.results = response.data;
													console
															.log($scope.results.length);

													$scope.checklist.list = [];
													var size = $scope.results.length;
													for (i = 0; i < size; i++) {
														$scope.checklist.list
																.push($scope.results[i]);
													}
													$scope.textAreaContent = "";
													for (i = 0; i < $scope.checklist.list.length; i++) {

														$scope.textAreaContent += $scope.checklist.list[i].keyword
																+ ",\n";
													}
													console
															.log($scope.checklist.list.length);
												},
												function errorCallback(response) {
													console.log("error");
												});
							};

							$scope.getAlldata();
						})
	</script>
</body>
</html>