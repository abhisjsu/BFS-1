class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        if ( prerequisites == null || prerequisites.length ==0 )
            return true;
         
        int inDegree[] = new int[numCourses];
        Map<Integer, List<Integer>> childCoursesByCurrentCourse = new HashMap<>();
        
        /**
            here we checking the indegree of each node and storing the childCourses(dependents)
            against the current course
        **/
        for(int prerequisite[]: prerequisites) {
            int currentCourse = prerequisite[0];
            int childCourse = prerequisite[1];
            
            inDegree[childCourse]++;
            if( childCoursesByCurrentCourse.get(currentCourse) == null) {
                childCoursesByCurrentCourse.put(currentCourse, new ArrayList<>());
            }
            // storing the childCourse against the currentCourse
            childCoursesByCurrentCourse.get(currentCourse).add(childCourse);
        }
        
        int coursesThatCanBeTaken = 0;   
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < numCourses; i++) {
            if ( inDegree[i] == 0 ) {
                queue.add(i);
                coursesThatCanBeTaken++;
            } 
        }
        
        if (coursesThatCanBeTaken == numCourses) {
            return true;
        }
        
        if ( coursesThatCanBeTaken == 0) {
            return false;
        }
        
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            List<Integer> childCourses =  childCoursesByCurrentCourse.get(currentCourse);
            
            if (childCourses != null && childCourses.size() > 0) {
                for(int childCourse: childCourses) {
                    int currentInDegree = --inDegree[childCourse];
                    
                    if( currentInDegree == 0) {
                        coursesThatCanBeTaken++;
                        if( coursesThatCanBeTaken == numCourses)  {
                            return true;
                        } else {
                            queue.add(childCourse);
                        }
                    }
                }
            }
        }
        
        return coursesThatCanBeTaken == numCourses;
    }
}
