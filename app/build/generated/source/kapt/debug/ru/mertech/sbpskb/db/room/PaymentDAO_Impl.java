package ru.mertech.sbpskb.db.room;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import ru.mertech.sbpskb.db.entity.PaymentStatusEntity;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PaymentDAO_Impl implements PaymentDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PaymentStatusEntity> __insertionAdapterOfPaymentStatusEntity;

  private final EntityDeletionOrUpdateAdapter<PaymentStatusEntity> __updateAdapterOfPaymentStatusEntity;

  public PaymentDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPaymentStatusEntity = new EntityInsertionAdapter<PaymentStatusEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `PaymentStatusEntity` (`sid`,`amount`,`qrId`,`paymentID`,`encoded`,`image`,`date`,`bankName`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PaymentStatusEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getAmount() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAmount());
        }
        if (value.getQrId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getQrId());
        }
        if (value.getPaymentID() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPaymentID());
        }
        if (value.getEncoded() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getEncoded());
        }
        stmt.bindLong(6, value.getImage());
        if (value.getDate() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getDate());
        }
        if (value.getBankName() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getBankName());
        }
      }
    };
    this.__updateAdapterOfPaymentStatusEntity = new EntityDeletionOrUpdateAdapter<PaymentStatusEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `PaymentStatusEntity` SET `sid` = ?,`amount` = ?,`qrId` = ?,`paymentID` = ?,`encoded` = ?,`image` = ?,`date` = ?,`bankName` = ? WHERE `sid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PaymentStatusEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getAmount() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAmount());
        }
        if (value.getQrId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getQrId());
        }
        if (value.getPaymentID() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPaymentID());
        }
        if (value.getEncoded() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getEncoded());
        }
        stmt.bindLong(6, value.getImage());
        if (value.getDate() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getDate());
        }
        if (value.getBankName() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getBankName());
        }
        stmt.bindLong(9, value.getId());
      }
    };
  }

  @Override
  public Object insertPayment(final PaymentStatusEntity paymentStatusEntity,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPaymentStatusEntity.insert(paymentStatusEntity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateRaiffPayment(final PaymentStatusEntity paymentStatusEntity,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfPaymentStatusEntity.handle(paymentStatusEntity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateTinkoffPayment(final PaymentStatusEntity paymentStatusEntity,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfPaymentStatusEntity.handle(paymentStatusEntity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public LiveData<List<PaymentStatusEntity>> loadPayments() {
    final String _sql = "SELECT * FROM paymentstatusentity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"paymentstatusentity"}, false, new Callable<List<PaymentStatusEntity>>() {
      @Override
      public List<PaymentStatusEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "sid");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfQrId = CursorUtil.getColumnIndexOrThrow(_cursor, "qrId");
          final int _cursorIndexOfPaymentID = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentID");
          final int _cursorIndexOfEncoded = CursorUtil.getColumnIndexOrThrow(_cursor, "encoded");
          final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfBankName = CursorUtil.getColumnIndexOrThrow(_cursor, "bankName");
          final List<PaymentStatusEntity> _result = new ArrayList<PaymentStatusEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final PaymentStatusEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpAmount;
            if (_cursor.isNull(_cursorIndexOfAmount)) {
              _tmpAmount = null;
            } else {
              _tmpAmount = _cursor.getString(_cursorIndexOfAmount);
            }
            final String _tmpQrId;
            if (_cursor.isNull(_cursorIndexOfQrId)) {
              _tmpQrId = null;
            } else {
              _tmpQrId = _cursor.getString(_cursorIndexOfQrId);
            }
            final String _tmpPaymentID;
            if (_cursor.isNull(_cursorIndexOfPaymentID)) {
              _tmpPaymentID = null;
            } else {
              _tmpPaymentID = _cursor.getString(_cursorIndexOfPaymentID);
            }
            final String _tmpEncoded;
            if (_cursor.isNull(_cursorIndexOfEncoded)) {
              _tmpEncoded = null;
            } else {
              _tmpEncoded = _cursor.getString(_cursorIndexOfEncoded);
            }
            final int _tmpImage;
            _tmpImage = _cursor.getInt(_cursorIndexOfImage);
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final String _tmpBankName;
            if (_cursor.isNull(_cursorIndexOfBankName)) {
              _tmpBankName = null;
            } else {
              _tmpBankName = _cursor.getString(_cursorIndexOfBankName);
            }
            _item = new PaymentStatusEntity(_tmpId,_tmpAmount,_tmpQrId,_tmpPaymentID,_tmpEncoded,_tmpImage,_tmpDate,_tmpBankName);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public int returnSid(final String date) {
    final String _sql = "SELECT sid FROM paymentstatusentity WHERE date = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (date == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, date);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
