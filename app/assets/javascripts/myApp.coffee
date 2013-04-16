app = angular.module('myApp', [])

NewGameCtrl = ($scope, $location) ->

    $scope.steps = [
        'Start',
        '1',
        '2',
        '3',
        'Finish'
    ]

    $scope.menuitems = [
        {name: "Page1", href: "/"}
        {name: "Page2", href: "/"}
        {name: "Page3", href: "/"}
    ]
    
    $scope.selection = $scope.steps[0]

    $scope.getCurrentStepIndex = ->
        _.indexOf($scope.steps, $scope.selection)
        
    $scope.goToStep = (index) ->
        $scope.selection = $scope.steps[index] if ( !_.isUndefined($scope.steps[index]) )

    $scope.hasNextStep = ->
        stepIndex = $scope.getCurrentStepIndex()
        nextStep = stepIndex + 1
        !_.isUndefined($scope.steps[nextStep])

    $scope.hasPreviousStep = ->
        stepIndex = $scope.getCurrentStepIndex()
        previousStep = stepIndex - 1
        !_.isUndefined($scope.steps[previousStep])

    $scope.incrementStep = ->
        (
            stepIndex = $scope.getCurrentStepIndex()
            nextStep = stepIndex + 1
            $scope.selection = $scope.steps[nextStep]
        ) if ( $scope.hasNextStep() )

    $scope.decrementStep = ->
        (
            stepIndex = $scope.getCurrentStepIndex()
            previousStep = stepIndex - 1
            $scope.selection = $scope.steps[previousStep]
        ) if ( $scope.hasPreviousStep() )