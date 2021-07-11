# panel
this panel was made for an increase in productivity, or whatever i did in 8th grade.  mostly used for schoolwork, programming, or general productivity.

kinda wanna make it look like [this](http://forums.ltheory.com/viewtopic.php?f=30&t=6459) ngl

colors scheme:
- \#F83940 (red orange)
- \#E8EBF0 (white)
- \#F8CD4F (yellow)
- \#444965 (navy blue)

## project structure
```
- resources
- src
    - main class
        - main render thread
    - components package
        - individual component `note, linked to main render threads.`
            - render method
            - background worker method
            - documentation
        - config components
```
multithreading guis are overkill; worker thread need not apply

## credits
[ice1000, for jimgui](https://github.com/ice1000/jimgui)

### date/grade for portfolio
- 4/26/2021, 8th grade: initial commit.
