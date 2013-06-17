
JGoodies FormLayout integration
-------------------------------

Plugin page: [http://artifacts.griffon-framework.org/plugin/jgoodies-forms](http://artifacts.griffon-framework.org/plugin/jgoodies-forms)


Provides integration with [JGoodies FormLayout](http://www.jgoodies.com/freeware/libraries/forms/). JGoodies is one of Swing's most well known 3rd party libraries.

Usage
-----

The following nodes will become available on a View script upon installing this plugin


| Node       | Property       | Type           | Default | Required | Bindable | Notes                                                            |
| ---------- | -------------- | -------------- | ------- | -------- | -------- | ---------------------------------------------------------------- |
| formLayout | columns        | ColumnSpec[]   |         | yes      | no       | either set a value for this property or set a value for the node |
|            | rows           | RowSpec[]      |         | no       | no       | either set a value for this property or set a value for the node |
| cc         | x              | int            | `1`     | no       | no       |                                                                  |
|            | y              | int            | `1`     | no       | no       |                                                                  |
|            | w              | int            | `1`     | no       | no       |                                                                  |
|            | y              | int            | `1`     | no       | no       |                                                                  |
|            | halign         | String         |         | no       | no       | must define a value for `valign` too                             |
|            | valign         | String         |         | no       | no       | must define a value for `halign` too                             |
|            | align          | String         |         | no       | no       | combined halign/valign                                           |
| form       | layout         | FormLayout     |         | yes      | no       | either set a value for this property or set a value for the node |
|            | target         | JPanel         |         | no       | no       | either set a value for this property or set a value for the node |
|            | resourceBundle | ResourceBundle |         | no       | no       |                                                                  |

Nodes and properties accept different types according to the following rules
**formLayout** node value may be any of

 *  a `FormLayout` instance
 *  a String/GString - only columnSpec will be defined
 *  a String[] - element[0] will be columnSpec, element[1] will be rowSpec
 *  a List - element[0] will be columnSpec, element[1] will be rowSpec

**formLayout.columns:** may be any of

 *  ColumnSpec[]
 *  String/GString
 *  List - elements will be joined with ","

**formLayout.rows:** may be any of

 *  RowSpec[]
 *  String/GString
 *  List - elements will be joined with ","

**form** node value may be any of

 *  a `JPanel` instance - must define a value for `layout:`
 *  a `FormLayout` instance - will use default JPanel unless `target:` is defined
 *  a String/GString - columnSpec will be used only. Will use default JPanel unless `target:` is defined
 *  a String[] - element[0] will be columnSpec, element[1] will be rowSpec. Will use default JPanel unless `target:` is defined
 *  a List - element[0] will be columnSpec, element[1] will be rowSpec. Will use default JPanel unless `target:` is defined

**form.layout:** may be any of

 *  a `FormLayout` instance
 *  a String/GString - only columnSpec will be defined
 *  a String[] - element[0] will be columnSpec, element[1] will be rowSpec
 *  a List - element[0] will be columnSpec, element[1] will be rowSpec

Additionally, you may call any method of `DefaultFormBuilder` inside **form**'s child closure. Here is an example

### Example

Using the `formLayout` node
    application(title:'JGoodies - Forms',
        pack: true,
        locationByPlatform:true,
        iconImage: imageIcon('/griffon-icon-48x48.png').image,
        iconImages: [imageIcon('/griffon-icon-48x48.png').image,
        imageIcon('/griffon-icon-32x32.png').image,
        imageIcon('/griffon-icon-16x16.png').image]) {
        formLayout(columns: "pref, 4dlu, 50dlu, 4dlu, min",
                      rows: "pref, 2dlu, pref, 2dlu, pref")
        label('Label1:', constraints: cc(x: 1, y: 1))
        textField(       constraints: cc(x: 3, y: 1, w: 3))
        label('Label2:', constraints: cc(x: 1, y: 3))
        textField(       constraints: cc(x: 3, y: 3))
        label('Label3:', constraints: cc(x: 1, y: 5))
        textField(       constraints: cc(x: 3, y: 5))
        button('...',    constraints: cc(x: 5, y: 5))
    }

Using the `form` node

        application(title:'JGoodies - Forms',
            pack: true,
            locationByPlatform:true,
            iconImage: imageIcon('/griffon-icon-48x48.png').image,
            iconImages: [imageIcon('/griffon-icon-48x48.png').image,
            imageIcon('/griffon-icon-32x32.png').image,
            imageIcon('/griffon-icon-16x16.png').image]) {
                form("right:max(40dlu;pref), 3dlu, 80dlu, 7dlu, right:max(40dlu;pref), 3dlu, 80dlu") {
                    setDefaultDialogBorder()

                    appendSeparator("Flange")

                    append("Identifier", textField())
                    nextLine()

                    append("PTI [kW]",   textField())
                    append("Power [kW]", textField())
                    append("s [mm]",     textField())
                    nextLine()

                    appendSeparator("Diameters")

                    append("da [mm]",    textField())
                    append("di [mm]",    textField())
                    append("da2 [mm]",   textField())
                    append("di2 [mm]",   textField())
                    append("R [mm]",     textField())
                    append("D [mm]",     textField())
                }
        }


