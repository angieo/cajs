var NewGameCtrl, app;
app = angular.module('myApp', []);
NewGameCtrl = function($scope, $location) {
  $scope.steps = ['Start', '1', '2', '3', 'Finish'];
  $scope.menuitems = [
    {
      name: "Page1",
      href: "/"
    }, {
      name: "Page2",
      href: "/"
    }, {
      name: "Page3",
      href: "/"
    }
  ];
  $scope.selection = $scope.steps[0];
  $scope.getCurrentStepIndex = function() {
    return _.indexOf($scope.steps, $scope.selection);
  };
  $scope.goToStep = function(index) {
    if (!_.isUndefined($scope.steps[index])) {
      return $scope.selection = $scope.steps[index];
    }
  };
  $scope.hasNextStep = function() {
    var nextStep, stepIndex;
    stepIndex = $scope.getCurrentStepIndex();
    nextStep = stepIndex + 1;
    return !_.isUndefined($scope.steps[nextStep]);
  };
  $scope.hasPreviousStep = function() {
    var previousStep, stepIndex;
    stepIndex = $scope.getCurrentStepIndex();
    previousStep = stepIndex - 1;
    return !_.isUndefined($scope.steps[previousStep]);
  };
  $scope.incrementStep = function() {
    var nextStep, stepIndex;
    if ($scope.hasNextStep()) {
      stepIndex = $scope.getCurrentStepIndex();
      nextStep = stepIndex + 1;
      return $scope.selection = $scope.steps[nextStep];
    }
  };
  return $scope.decrementStep = function() {
    var previousStep, stepIndex;
    if ($scope.hasPreviousStep()) {
      stepIndex = $scope.getCurrentStepIndex();
      previousStep = stepIndex - 1;
      return $scope.selection = $scope.steps[previousStep];
    }
  };
};