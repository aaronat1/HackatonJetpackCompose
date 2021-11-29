import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.aaronat1.hackaton.R
import com.aaronat1.hackaton.ui.screens.register.HackatonIcon
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun DatePickerView(
        context: Context,
        value: String,
        setValue: (String) -> Unit
) {
    val mYear: Int
    val mMonth: Int
    val mDay: Int
    val now = Calendar.getInstance()
    mYear = now.get(Calendar.YEAR)
    mMonth = now.get(Calendar.MONTH)
    mDay = now.get(Calendar.DAY_OF_MONTH)
    now.time = Date()

    val datePickerDialog = DatePickerDialog(
            context,
            { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                val cal = Calendar.getInstance()
                cal.set(year, month, dayOfMonth)
                setValue(SimpleDateFormat("dd-MM-yyyy").format(cal.time))
            }, mYear, mMonth, mDay
    )

    val day1= Calendar.getInstance()
    day1.set(1910,1,1)
    datePickerDialog.datePicker.minDate = day1.timeInMillis
    datePickerDialog.datePicker.maxDate = Calendar.getInstance().timeInMillis
    Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
                value =  value,
                onValueChange = setValue,
                placeholder = { Text(text = stringResource(R.string.date)) },
                enabled = false,
                colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor =  colorResource(id = R.color.purple_200),
                        unfocusedIndicatorColor = Color.Gray),
                leadingIcon = {
                    HackatonIcon(Icons.Default.DateRange)

                },
                modifier= Modifier.clickable {
                    datePickerDialog.show()
                }
        )
    }
}
