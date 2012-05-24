/*
 * Copyright 2010-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the 'License');
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an 'AS IS' BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author Andres Almiray
 */
class MiglayoutGriffonPlugin {
    // the plugin version
    String version = '0.5'
    // the version or versions of Griffon the plugin is designed for
    String griffonVersion = '0.9.5 > *'
    // the other plugins this plugin depends on
    Map dependsOn = [swing: '0.9.5']
    // resources that are included in plugin packaging
    List pluginIncludes = []
    // the plugin license
    String license = 'Apache Software License 2.0'
    // Toolkit compatibility. No value means compatible with all
    // Valid values are: swing, javafx, swt, pivot, gtk
    List toolkits = ['swing']
    // Platform compatibility. No value means compatible with all
    // Valid values are:
    // linux, linux64, windows, windows64, macosx, macosx64, solaris
    List platforms = []
    // URL where documentation can be found
    String documentation = ''
    // URL where source can be found
    String source = 'https://github.com/griffon/griffon-jgoodies-forms-plugin'

    List authors = [
        [
            name: 'Andres Almiray',
            email: 'aalmiray@yahoo.com'
        ]
    ]
    String title = 'JGoodies FormLayout integration'
    String description = '''
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

'''
}
