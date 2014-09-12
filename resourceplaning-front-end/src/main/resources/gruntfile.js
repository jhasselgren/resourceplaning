module.exports = function(grunt){
	grunt.initConfig({

        less: {
            development: {
                options: {
                    paths: ["assets/css"]
                },
                files: {"path/to/result.css": "path/to/source.less"}
            },
            production: {
                options: {
                    paths: ["assets/css"],
                    cleancss: true
                },
                files: {"path/to/result.css": "path/to/source.less"}
            }
        },
        spawn: {
        	var done = this.async();
            grunt.util.spawn({
                grunt: true,
                args: [''],
                opts: {
                    cwd: 'components/bootstrap-3.2.0'
                }
            }, function (err, result, code) {
                done();
            });
        }
    });
    grunt.loadNpmTasks('grunt-contrib-less');
    grunt.registerTask('default', ['less', 'spawn']);
    
};