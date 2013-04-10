describe('Controllers', function() {
    describe('SimpleCtrl', function() {
        it('should list 4 items', function() {
            var scope = {}, ctrl = new SimpleCtrl(scope);
            expect(scope.items.length).toBe(4);
        });
    });
});