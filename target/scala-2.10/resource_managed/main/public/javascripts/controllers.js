var SimpleCtrl;
SimpleCtrl = function($scope) {
  $scope.items = [
    {
      name: "Item1",
      age: 2
    }, {
      name: "Item2",
      age: 1
    }, {
      name: "Item3",
      age: 3
    }, {
      name: "Item4",
      age: 0
    }
  ];
  return $scope.menuitems = [
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
};